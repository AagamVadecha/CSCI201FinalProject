package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddOfficeHours
 */
@WebServlet("/AddOfficeHours")
public class AddOfficeHours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOfficeHours() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String day = request.getParameter("day");
		String hourStart = request.getParameter("hourStart");
		String hourEnd = request.getParameter("hourEnd");
		
		AddNewOfficeHour(day, hourStart, hourEnd);
		
		System.out.println(day);
		System.out.println(hourStart);
		System.out.println(hourEnd);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InstructorCalendar.jsp");
		dispatcher.forward(request, response);
	}
	
	
	public static void AddNewOfficeHour(String day, String hourStart, String hourEnd)
	{
		//ADD TO OFFICE HOUR TABLE
	}

}
