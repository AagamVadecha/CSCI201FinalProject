package servlets;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RemoveOfficeHours")
public class RemoveOfficeHours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveOfficeHours() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /* This servlet removes the specific hours for the course from the database 
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	      String day = request.getParameter("day");
//        String hourStart = request.getParameter("hourStart");
//        String hourEnd = request.getParameter("hourEnd");
        HttpSession session = request.getSession(); 
//        String course = (String) session.getAttribute("courseName");
//        String course = request.getParameter("name");
        
        // begin menu implementation 
        int index = Integer.parseInt(request.getParameter("value"));
        ArrayList<ArrayList<String>> officeHours = (ArrayList<ArrayList<String>>) session.getAttribute("courses"); 
        String course, day, hourStart, hourEnd; 
        // get day, hourStart, hourEnd 
        course = officeHours.get(0).get(index);
        day = officeHours.get(1).get(index);
        hourStart = officeHours.get(2).get(index);
        hourEnd = officeHours.get(3).get(index);
        // end menu implementation   
        
        PreparedStatement ps = null; 
        Connection conn = null;
        Statement st = null; 
        ResultSet rs = null;
        
        // TODO - UPDATE WITH FINAL DATABASE
        String sql = "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
        
        try {
            conn = DriverManager.getConnection(sql);
            st = conn.createStatement(); 
            
            // remove office hours from 'officeHour' table   
            String statement = "delete from officeHour where courseID=(select courseID from course where courseName=\'" + course + "\') and day=\'" 
                + day +"\' and hourStart=\'" + hourStart + "\' and hourEnd=\'" + hourEnd + "\'"; 
            
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
        
        // TODO - fix next page? 
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
