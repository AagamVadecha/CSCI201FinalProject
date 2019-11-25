package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.QueueManager;

/**
 * Servlet implementation class LeaveQueueServlet
 */
@WebServlet("/LeaveQueueServlet")
public class LeaveQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveQueueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Delete studnet question in DB
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// called by ajax call
		HttpSession session = request.getSession();
		int courseID = (int) session.getAttribute("courseID");
		int userID = (int) session.getAttribute("userID");
	    
	    session.setAttribute("inQueue", false);
	    QueueManager.cancelQuestion(courseID, userID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
