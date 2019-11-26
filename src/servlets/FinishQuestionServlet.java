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
 * Servlet implementation class FinishQuestionServlet
 */
@WebServlet("/FinishQuestionServlet")
public class FinishQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinishQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Delete student question in DB
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		int courseID = (int) session.getAttribute("courseID");
		QueueManager.ejectQuestion(courseID,  -1); // -1 indicate remove 1st student
		session.setAttribute("InQueue", false);
		String username=QueueManager.getTopStudentInfo(courseID).firstElement();
		String fName=QueueManager.getTopStudentInfo(courseID).lastElement();
		javaMailer jm =new javaMailer(username, fName);
		jm.start();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
