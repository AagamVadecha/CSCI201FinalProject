package classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class QueueDBM {
/**
	public static void makeTable(int courseID) {
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
	*/
	
	public static void insertEntry(int courseID, int studentID, String text) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "jdbc:mysql://google/ClientRecords" // TODO db name
				+ "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
				+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
				+ "&user=zhoue&password=password1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql);
			ps = conn.prepareStatement("insert into queue(studentID, text, courseID) values(?, ?, ?)"); 
			ps.setInt(1,  studentID);
			ps.setString(2, text);
			ps.setInt(3, courseID);
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
	
	/**
	public static void promoteEntry(int courseID, int studentID) {
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
	*/
	
	
	public static void deleteEntry(int courseID, int studentID) {
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
	
	public static Vector<Vector<String>> printTable(int courseID) {
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

		return ans;
	}
	
	public static void deleteTable(int courseID) {
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
	
	public static void addStrike(int studentID) {
		//wait to confirm user table's structure.
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
	
	
}
