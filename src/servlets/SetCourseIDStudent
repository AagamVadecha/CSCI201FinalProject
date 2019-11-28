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
 * Servlet implementation class SetCourseID
 */
@WebServlet("/SetCourseIDStudent")
public class SetCourseIDStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SetCourseIDStudent() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String courseName = (String) request.getParameter("course_list");
	    int courseID = -1;
	    PreparedStatement ps = null; 
        Connection conn = null;
        ResultSet rs = null;
        HttpSession session = request.getSession(); 
        
        // TODO - UPDATE WITH FINAL DATABASE
        String sql = "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
        
//        String sql = "jdbc:mysql://google/OHScheduler"
//            + "?cloudSqlInstance=zhoue-csci201l-lab7:us-central1:sql-db-lab7"
//            + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory" + "&useSSL=false"
//            + "&user=zhoue&password=password1234";
        
        try {
            conn = DriverManager.getConnection(sql);
            
            String statement = "select courseID from course where courseName=\"" + courseName + "\"" ; 
            ps = conn.prepareStatement(statement);
            boolean success = ps.execute(statement); 
            
            if (success) {
                rs = ps.getResultSet();
                rs.next();
                courseID = rs.getInt("courseID");
            }
            else {
                throw new SQLException("Could not retrieve courseID");
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
        
        session.setAttribute("courseID", courseID);
        session.setAttribute("courseName", courseName);
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/StudentCalendar.jsp");
        
        try {
            dispatch.forward(request, response);
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } 
	}

}
