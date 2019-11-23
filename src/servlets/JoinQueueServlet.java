package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JoinQueueServlet
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
	    String comment = request.getParameter("comment");
		HttpSession session = request.getSession();
		String courseName = (String) session.getAttribute("courseName");
		//WHENEVER YOU FIGURE OUT LOGIN AND REGISTER SAVE THE FIRST NAME INTO THE SESSION VARIABLE
		//PASS THIS VARIABLE TO joinQueue, REPLACE ELISE :)
	    joinQueue("elise",courseName,comment);
		
	}
	
	//STUDENT CLICKS  JOIN QUEUE
	public static void joinQueue(String name, String courseName, String comment)
	{
		//INSERT INTO QUEUE DATABASE
	}

}
