package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartOfficeHoursServlet
 */
@WebServlet("/StartOfficeHoursServlet")
public class StartOfficeHoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartOfficeHoursServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StartOfficeHours();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InstructorCalendar.jsp");
		dispatcher.forward(request, response);
	}
	
	public static void StartOfficeHours()
	{
			
		//NETWORKING STUFF	
	}
}
