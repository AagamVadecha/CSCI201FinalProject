package classes;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;

public class UserManager {
    // The higher the number of iterations the more
    // expensive computing the hash is for us and
    // also for an attacker.
    private static final int iterations = 20*1000;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    /** Computes a salted PBKDF2 hash of given plaintext password
     suitable for storing in a database.
     Empty passwords are not supported. */
    public static String getSaltedHash(String password) throws Exception {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        // store the salt with the password
        return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
    }

    /** Checks whether given plaintext password corresponds
     to a stored salted hash of the password. */
    public static boolean check(String password, String stored) throws Exception{
        String[] saltAndHash = stored.split("\\$");
        if (saltAndHash.length != 2) {
            throw new IllegalStateException(
                    "The stored password must have the form 'salt$hash'");
        }
        String hashOfInput = hash(password, Base64.decodeBase64(saltAndHash[0]));
        return hashOfInput.equals(saltAndHash[1]);
    }

    // using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
    // cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
    private static String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, desiredKeyLen));
        return Base64.encodeBase64String(key.getEncoded());
    }

    static String sql  = "jdbc:mysql://google/OHScheduler?cloudSqlInstance=tough-shard-260720:us-west1:csci201final&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false";

    public static boolean register(String username, String password, String fname, String lname, int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       // String sql =                //"jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
//        String sql = "jdbc:mysql://google/OHScheduler"
//                + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
//                + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sql, "root", "root");
            String statement = "";
            String statement1 = "SELECT * FROM instructor where username = ?";
            String statement2 =  "SELECT * FROM student where username = ?";

            //check if an instructor already exists with that username
            ps = conn.prepareStatement(statement1);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                if (ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(conn !=null)
                    conn.close();
                return false;
            }
            if (ps != null)
                ps.close();
            if(rs != null)
                rs.close();


            //check if a student exists with that username
            ps = conn.prepareStatement(statement2);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                if (ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(conn !=null)
                    conn.close();
                return false;
            }
            if (ps != null)
                ps.close();
            if(rs != null)
                rs.close();
          
            if (id == 2)
                statement = "INSERT INTO instructor(username,password,fName,lName) VALUES(?,?,?,?)";
            else if (id == 1)
                statement = "INSERT INTO student(username,password,fName,lName,strike) VALUES(?,?,?,?,?)";
            ps = conn.prepareStatement(statement);
            ps.setString(1, username);
            ps.setString(2, getSaltedHash(password));
            ps.setString(3, fname);
            ps.setString(4, lname);
            if (id==1) {
                ps.setInt(5, 0);
            }
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("In UserManager-Register" + " " + sqle.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        }
        return true;
    }

    public static boolean verify(String username, String password, int id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

//        String sql = "jdbc:mysql://google/OHScheduler"
//              + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
//              + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
//              + "&user=zhoue&password=password1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sql, "root","root");
            String statement ="";
/*            if(id == 2)
                statement = "SELECT * FROM instructor where username = ?  AND password = ?";
            else if(id==1)
                statement =  "SELECT * FROM student where username = ?  AND password = ?";*/
            if(id == 2)
                statement = "SELECT * FROM instructor where username = ?";
            else if(id==1)
                statement =  "SELECT * FROM student where username = ?";

            ps = conn.prepareStatement(statement); // prepare statement
            ps.setString(1, username);
//            System.out.println("password: " + getSaltedHash(password));
//            ps.setString(2,getSaltedHash(password));
            rs = ps.executeQuery(); // execute query, return result set
            if(!rs.next()) {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                return false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return false; 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        }
        return true;
    }

    public static ArrayList<String> login(String username, String password, int id) {
        ArrayList<String> ans= new ArrayList<String>();
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            //          String sql = "jdbc:mysql://google/OHScheduler"
//                  + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
//                  + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
//                  + "&user=zhoue&password=password1234";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(sql, "root", "root");
                String statement = "";
//                if(id == 2)
//                    statement = "SELECT * FROM instructor where username = ?  AND password = ?";
//                else if(id==1)
//                    statement =  "SELECT * FROM student where username = ?  AND password = ?";

                if(id == 2)
                    statement = "SELECT * FROM instructor where username = ?";
                else if(id==1)
                    statement =  "SELECT * FROM student where username = ?";

                ps = conn.prepareStatement(statement); // prepare statement
                ps.setString(1, username);
//                ps.setString(2,getSaltedHash(password));
                rs = ps.executeQuery(); // execute query, return result set
                if(rs.next()){
                    if(!check(password,rs.getString(3)))
                        return ans;
                    ans.add(Integer.toString(rs.getInt(1)));
                    ans.add(rs.getString(2));
                    ans.add(rs.getString(3));
                    ans.add(rs.getString(4));
                    ans.add(rs.getString(5));
                    if(id==1)
                        ans.add(Integer.toString(rs.getInt(6)));
                }
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException sqle) {
                    System.out.println(sqle.getMessage());
                }
            }

            return ans;
    }
}
