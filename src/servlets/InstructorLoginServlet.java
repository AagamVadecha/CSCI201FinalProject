package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InstructorLoginServlet
 */
@WebServlet("/InstructorLoginServlet")
public class InstructorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get username and password from form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//Save in session
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Instructor.jsp");
		rd.forward(request, response);
	}
}
