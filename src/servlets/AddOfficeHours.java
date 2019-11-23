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

@WebServlet("/AddOfficeHours")
public class AddOfficeHours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddOfficeHours() {
        super();
        // TODO Auto-generated constructor stub
    }

    /* This servlet adds office hours for an instructor's course. This will update the 'officeHour' table 
     * in the database. 
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String day = request.getParameter("day");
		String hourStart = request.getParameter("hourStart");
		String hourEnd = request.getParameter("hourEnd");
		HttpSession session = request.getSession(); 
		String course = (String) session.getAttribute("courseName");
		
        /*
         * System.out.println(day); System.out.println(hourStart); System.out.println(hourEnd);
         */
		
		PreparedStatement ps = null; 
        Connection conn = null;
        Statement st = null; 
        ResultSet rs = null;
        
        // TODO - UPDATE WITH FINAL DATABASE
        String sql = "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
        
        try {
            conn = DriverManager.getConnection(sql);
            st = conn.createStatement(); 
            
            // insert office hours into database  
            String statement = "insert into officeHour (courseID, day, hourStart, hourEnd) values ((select courseID from course where courseName=\'" + course + "\')," 
                + day +"," + hourStart + "," + hourEnd + ")"; 
            
            ps = conn.prepareStatement(statement);
            ps.executeUpdate(statement);
            
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
        
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/InstructorCalendar.jsp");
        
        try {
            dispatch.forward(request, response);
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } 
	}
	
}
