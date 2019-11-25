package classes;

import java.sql.*;
import java.util.Vector;

public class UserManager {
    public static void register(String username, String password, String fname, String lname, int id){
        //going to Use Elizabeth's SQL code
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "jdbc:mysql://google/ClientRecords" // TODO db name
                + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
                + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
                + "&user=zhoue&password=password1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sql);
            String statement = ""; // TODO
            ps = conn.prepareStatement(statement);
//			ps.setInt(1,  ++countValue);
//			ps.setInt(2, pageID);
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
    }

    public static boolean verify(String username, String password){
        Vector<Vector<String>> ans=new Vector<Vector<String>>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "jdbc:mysql://google/ClientRecords" // TODO db name
                + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
                + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
                + "&user=zhoue&password=password1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sql);
            String statement = ""; // TODO
            ps = conn.prepareStatement(statement); // prepare statement
//			ps.setInt(1,  portNum);
//			ps.setString(2, IPAddress);
            rs = ps.executeQuery(); // execute query, return result set
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

    public static ResultSet login(String username, String password) {
        if(verify(username, password)) {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "jdbc:mysql://google/ClientRecords" // TODO db name
                    + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
                    + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
                    + "&user=zhoue&password=password1234";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(sql);
                String statement = ""; // TODO
                ps = conn.prepareStatement(statement); // prepare statement
//			ps.setInt(1,  portNum);
//			ps.setString(2, IPAddress);
                rs = ps.executeQuery(); // execute query, return result set
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
