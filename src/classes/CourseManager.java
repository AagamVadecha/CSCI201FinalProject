package classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class CourseManager {

    /*
     * This function returns an ArrayList of strings containing all the course names that exist in
     * the database.
     */
    public static ArrayList<String> getAllCourses() {
        ArrayList<String> allCourses = new ArrayList<String>();
        PreparedStatement ps = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        // TODO - UPDATE WITH FINAL DATABASE
        String sql =
            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";

        try {
            conn = DriverManager.getConnection(sql);
            st = conn.createStatement();

            // selecting all courses from 'course' table;
            String statement = "select * from course";
            ps = conn.prepareStatement(statement);
            boolean selectedCourses = ps.execute(statement);

            // fill array if successful
            if (selectedCourses) {
                rs = ps.getResultSet();
                while (rs.next()) {
                    String courseName = rs.getString("courseName");
                    allCourses.add(courseName);
                }
            } else {
                throw new SQLException("Could not retrieve courses");
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
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

        return allCourses;
    }

    /*
     * This function returns an ArrayList of strings containing the courses for a specific
     * instructor Parameters: instructor's email
     */
    public static ArrayList<String> getInstructorCourses(String username) {
        ArrayList<String> instructorCourses = new ArrayList<String>();
        PreparedStatement ps = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        // TODO - UPDATE WITH FINAL DATABASE
        String sql =
            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";

        try {
            conn = DriverManager.getConnection(sql);
            st = conn.createStatement();

            // get instructor's id
            String statement =
                "select instructorID from instructor where username=\'" + username + "\'";
            int id = -1;

            ps = conn.prepareStatement(statement);
            boolean selectedCourses = ps.execute(statement);

            if (selectedCourses) {
                rs = ps.getResultSet();
                rs.next();
                id = rs.getInt("instructorID");
            } else {
                throw new SQLException("Could not retrieve instructor id");
            }

            // select instructor's courses
            statement =
                "select c.courseName from course c inner join instructorCourse ic on ic.instructorID="
                    + id + " and ic.courseID = c.courseID";
            ps = conn.prepareStatement(statement);
            selectedCourses = ps.execute(statement);

            if (selectedCourses) {
                rs = ps.getResultSet();
                while (rs.next()) {
                    String courseName = rs.getString("courseName");
                    instructorCourses.add(courseName);
                }
            } else {
                throw new SQLException("Could not retrieve instructor courses");
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
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

        return instructorCourses;
    }

    /* Removes a course from the tables - for Instructors TODO */
    public static void removeCourse(String courseName) {
        PreparedStatement ps = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        // TODO - UPDATE WITH FINAL DATABASE
        String sql =
            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";

        try {
            conn = DriverManager.getConnection(sql);
            st = conn.createStatement();

            // get instructor's id
            String statement =
                "select courseID from course where courseName=\'" + courseName + "\'";
            int id = -1;
            ps = conn.prepareStatement(statement);
            boolean selectedCourses = ps.execute(statement);

            if (selectedCourses) {
                rs = ps.getResultSet();
                rs.next();
                id = rs.getInt("courseID");
            } else {
                throw new SQLException("Could not retrieve course id");
            }


        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
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

    /*
     * This function returns an ArrayList containing all the information for an instructor's office
     * hours. 
     * Parameters: instructor's email
     */
    public static ArrayList<ArrayList<String>> getOfficeHoursInstructor(String username) {
        ArrayList<ArrayList<String>> hours = new ArrayList<ArrayList<String>>();

        ArrayList<String> courseNames = new ArrayList<String>();
        ArrayList<String> day = new ArrayList<String>();
        ArrayList<String> hourStart = new ArrayList<String>();
        ArrayList<String> hourEnd = new ArrayList<String>();

        PreparedStatement ps = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        // TODO - UPDATE WITH FINAL DATABASE
        String sql =
            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";

        try {
            conn = DriverManager.getConnection(sql);
            st = conn.createStatement();

            String statement =
                "select courseID from instructorCourse where instructorID=(select instructorID from instructor where username=\'"
                    + username + "\')";

            ps = conn.prepareStatement(statement);
            boolean success = ps.execute(statement);

            if (success) {
                rs = ps.getResultSet();
                while (rs.next()) {
                    int courseID = rs.getInt("courseID");
                    String statement2 =
                        "select courseName, day, hourStart, hourEnd from officeHour o inner join course c on c.courseID=o.courseID and c.courseID="
                            + courseID;
                    ps = conn.prepareStatement(statement2);
                    success = ps.execute(statement2);

                    if (success) {
                        rs = ps.getResultSet();
                        while (rs.next()) {
                            courseNames.add(rs.getString("courseName"));
                            day.add(rs.getString("day"));
                            hourStart.add(Integer.toString(rs.getInt("hourStart")));
                            hourEnd.add(Integer.toString(rs.getInt("hourEnd")));
                        }
                    }
                }
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
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
        hours.add(courseNames); 
        hours.add(day);
        hours.add(hourStart);
        hours.add(hourEnd);
        return hours;
    }

    /* This function returns all the office hours for a specific course. 
     * Parameters: course name 
     */
    public static ArrayList<ArrayList<String>> getOfficeHoursCourse(String courseName) {
        ArrayList<ArrayList<String>> hours = new ArrayList<ArrayList<String>>();

        ArrayList<String> day = new ArrayList<String>();
        ArrayList<String> hourStart = new ArrayList<String>();
        ArrayList<String> hourEnd = new ArrayList<String>();

        PreparedStatement ps = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        // TODO - UPDATE WITH FINAL DATABASE
        String sql =
            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";

        try {
            conn = DriverManager.getConnection(sql);
            st = conn.createStatement();

            String statement =
                "select day, hourStart, hourEnd from officeHour where courseID=(select courseID from course where courseName=\'"
                    + courseName + "\')";
            ps = conn.prepareStatement(statement);
            boolean success = ps.execute(statement);

            if (success) {
                rs = ps.getResultSet();
                while (rs.next()) {
                    day.add(rs.getString("day"));
                    hourStart.add(Integer.toString(rs.getInt("hourStart")));
                    hourEnd.add(Integer.toString(rs.getInt("hourEnd")));
                }
            }


        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
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
        hours.add(day);
        hours.add(hourStart);
        hours.add(hourEnd);
        return hours;
    }
}
