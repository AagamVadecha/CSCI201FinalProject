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
 * Servlet implementation class QueueServlet
 */
@WebServlet("/JoinQueueServlet")
public class JoinQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinQueueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//STUDENT COMMENT
		// called by ajax call
		HttpSession session = request.getSession();
		int courseID = (int) session.getAttribute("courseID");
		int userID = (int) session.getAttribute("userID");
	    String text = request.getParameter("comment");
	    session.setAttribute("InQueue", true);
		//WHENEVER YOU FIGURE OUT LOGIN AND REGISTER SAVE THE FIRST NAME INTO THE SESSION VARIABLE
	    // save userID
		//PASS THIS VARIABLE TO joinQueue, REPLACE ELISE :)
	    QueueManager.addQuestion(courseID, userID, text);
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/StudentQueue.jsp");
		dispatcher.forward(request, response);
		
	}
	
//	//STUDENT CLICKS  JOIN QUEUE
//	public static void joinQueue(String name, String courseName, String comment)
//	{
//		//INSERT INTO QUEUE DATABASE
//	}

}
