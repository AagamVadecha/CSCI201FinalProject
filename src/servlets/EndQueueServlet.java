package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.QueueManager;
/**
 * Servlet implementation class EndQueueServlet
 */
@WebServlet("/EndQueueServlet")
public class EndQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndQueueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO END Queue in DB
		//forward to InstructorCalendar.jsp
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// param courseID
		HttpSession session = request.getSession();
		int courseID = (int) session.getAttribute("courseID");
		QueueManager.stopQueue(courseID);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InstructorCalendar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
