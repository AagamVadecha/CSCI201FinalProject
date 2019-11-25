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
	 * public static void makeTable(int courseID) { Connection conn = null;
	 * PreparedStatement ps = null; String sql = "jdbc:mysql://google/OHScheduler"
	 * // TODO db name +
	 * "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7" +
	 * "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false" +
	 * "&user=zhoue&password=password1234"; try {
	 * Class.forName("com.mysql.jdbc.Driver"); conn =
	 * DriverManager.getConnection(sql); String statement = ""; // TODO ps =
	 * conn.prepareStatement(statement); // ps.setInt(1, ++countValue); //
	 * ps.setInt(2, pageID); ps.executeUpdate();
	 * 
	 * 
	 * } catch (SQLException sqle) { System.out.println(sqle.getMessage()); } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); } finally { try { if (ps !=
	 * null) { ps.close(); } if (conn != null) { conn.close(); } } catch
	 * (SQLException sqle) { System.out.println(sqle.getMessage()); } } }
	 */

	public static void insertEntry(int courseID, int studentID, String text) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "jdbc:mysql://google/OHScheduler" // TODO db name
				+ "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
				+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
				+ "&user=zhoue&password=password1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql);
			ps = conn.prepareStatement("insert into queue(studentID, text, courseID) values(?, ?, ?)");
			ps.setInt(1, studentID);
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
	 * public static void promoteEntry(int courseID, int studentID) { Connection
	 * conn = null; PreparedStatement ps = null; String sql =
	 * "jdbc:mysql://google/OHScheduler" // TODO db name +
	 * "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7" +
	 * "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false" +
	 * "&user=zhoue&password=password1234"; try {
	 * Class.forName("com.mysql.jdbc.Driver"); conn =
	 * DriverManager.getConnection(sql); String statement = ""; // TODO ps =
	 * conn.prepareStatement(statement); // ps.setInt(1, ++countValue); //
	 * ps.setInt(2, pageID); ps.executeUpdate(); } catch (SQLException sqle) {
	 * System.out.println(sqle.getMessage()); } catch (ClassNotFoundException e) {
	 * e.printStackTrace(); } finally { try { if (ps != null) { ps.close(); } if
	 * (conn != null) { conn.close(); } } catch (SQLException sqle) {
	 * System.out.println(sqle.getMessage()); } } }
	 */

	public static void deleteEntry(int courseID, int studentID) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "jdbc:mysql://google/OHScheduler" // TODO db name
				+ "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
				+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
				+ "&user=zhoue&password=password1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql);
			if (studentID == -1) { // delete top student
				ps = conn.prepareStatement("delete top(1) from queue where courseID=? order by time");
				ps.setInt(1, courseID);
				ps.executeUpdate();
			} else {
				ps = conn.prepareStatement("delete from queue where courseID=? and studentID=?");
				ps.setInt(1, courseID);
				ps.setInt(2, studentID);
				ps.executeUpdate();
			}
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

	// returns queue for specified course as string w ea entry as username and text
	// 0:username:text\n
	public static String selectQueue(int courseID) {
		String queue = "";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "jdbc:mysql://google/OHScheduler" // TODO db name
				+ "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
				+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
				+ "&user=zhoue&password=password1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql);
			ps = conn.prepareStatement("select * from queue where courseID=?"); // prepare statement
			ps.setInt(1, courseID);
			rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				String text = rs.getString("text");
				int studentID = rs.getInt("studentID");
				// get username assoc w studentID
				ps = conn.prepareStatement("select username from student where studentID=?"); // prepare statement
				ps.setInt(1, studentID);
				rs = ps.executeQuery();
				String username = null;
				while (rs.next()) {
					username = rs.getString("username");
				}
				queue += i + ":" + username + ":" + text + "\n";
				i++;
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

		return queue;
	}

	public static void deleteQueue(int courseID) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "jdbc:mysql://google/OHScheduler" // TODO db name
				+ "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
				+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
				+ "&user=zhoue&password=password1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql);
			ps = conn.prepareStatement("delete from queue where courseID=?");
			ps.setInt(1, courseID);
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

	// returns studentID for top student in queue for given course
	public static int getTopStudentID(int courseID) {
		int studentID = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "jdbc:mysql://google/OHScheduler" // TODO db name
				+ "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
				+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
				+ "&user=zhoue&password=password1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql);
			ps = conn.prepareStatement("select studentID from queue where courseID=? order by time limit 1"); // prepare statement
			ps.setInt(1, courseID);
			rs = ps.executeQuery();
			if (rs.next()) {
				studentID = rs.getInt("studentID");
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

		return studentID;
	}

	public static void addStrike(int studentID) {
		// wait to confirm user table's structure.
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "jdbc:mysql://google/OHScheduler" // TODO db name
				+ "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
				+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
				+ "&user=zhoue&password=password1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql);
			ps = conn.prepareStatement("update student set strike=strike+1 where studentID=?");
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
