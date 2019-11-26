package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateCourse
 */
@WebServlet("/CreateCourse")
public class CreateCourse extends HttpServlet {
    public CreateCourse() {
        super();
    }
    
    /* This servlet adds a new course to the 'course' table, updates the 'instructorCourse' table, and updates the 'officeHour' table 
     * with the new course. Forwards to the instructor.jsp 
    */ 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(); 
	    String username = (String) session.getAttribute("username");
	    String course = request.getParameter("new"); 
	    
	    PreparedStatement ps = null; 
	    Connection conn = null;
	    Statement st = null; 
	 
	    // TODO - UPDATE WITH FINAL DATABASE
	    //String sql = "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
        
        String sql = "jdbc:mysql://google/OHScheduler"
            + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
            + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
            + "&user=zhoue&password=password1234";
        
	    try {
	        conn = DriverManager.getConnection(sql);
	        st = conn.createStatement(); 
	        
            // inserting course into course table 
	        String statement = "insert into course (courseName) values (course)"; 
	        ps = conn.prepareStatement(statement);
	        ps.executeUpdate();
	        
	        // updating instructorCourse table associating the instructor with this course  
	        statement = "insert into instructorCourse (courseID, instructorID) values ( (select courseID from course where courseName=\"" + course + "\") ,"
	            + "(select instructorID from instructor where username=\"" + username + "\"))"; 
	        ps = conn.prepareStatement(statement);
            ps.executeUpdate();
          
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
	    
	    // forward to instructor jsp  
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/Instructor.jsp");
        
        try {
            dispatch.forward(request, response);
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } 
	}


}
