package classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class UserManager {
    public static boolean register(String username, String password, String fname, String lname, int id) {
        //going to Use Elizabeth's SQL code
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "jdbc:mysql://google/OHScheduler"
                + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
                + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
                + "&user=zhoue&password=password1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sql);
            String statement = "";
            String statement1 = "SELECT * FROM instructor where username = ?";
            String statement2 = "SELECT * FROM student where username = ?";
            ps = conn.prepareStatement(statement1);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
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
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
            ps = conn.prepareStatement(statement2);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()) {
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
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (id == 2)
                statement = "INSERT INTO instructor(username,password,fName,lName) VALUES(?,?,?,?)";
            else if (id == 1)
                statement = "INSERT INTO student(username,password,fName,lName) VALUES(?,?,?,?)";
            ps = conn.prepareStatement(statement);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fname);
            ps.setString(4, lname);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException e) {
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
        Vector<Vector<String>> ans=new Vector<Vector<String>>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "jdbc:mysql://google/OHScheduler"
                + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
                + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
                + "&user=zhoue&password=password1234";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sql);
            String statement ="";
            if(id == 2)
                statement = "SELECT * FROM instructor where username = ?  AND password = ?";
            else if(id==1)
                statement =  "SELECT * FROM student where username = ?  AND password = ?";
            ps = conn.prepareStatement(statement); // prepare statement
//			ps.setInt(1,  portNum);
//			ps.setString(2, IPAddress);
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
        } catch (ClassNotFoundException e) {
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
        return !ans.isEmpty();
    }

    public static ArrayList<String> login(String username, String password, int id) {
        ArrayList<String> ans= new ArrayList<String>();
        if(verify(username, password, id)) {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "jdbc:mysql://google/OHScheduler"
                    + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
                    + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
                    + "&user=zhoue&password=password1234";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(sql);
                String statement = "";
                if(id == 2)
                    statement = "SELECT * FROM instructor where username = ?  AND password = ?";
                else if(id==1)
                    statement =  "SELECT * FROM student where username = ?  AND password = ?";
                ps = conn.prepareStatement(statement); // prepare statement
                ps.setString(1, username);
                ps.setString(2,password);
                rs = ps.executeQuery(); // execute query, return result set
                if(rs.next()){
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
        return ans;
    }
}
