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
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get username and password from form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//***************
				//PLEASE VALIDATE LOGIN AND ACTUALLY LOG IN
				//use login() and verify()
				//IF LOGIN SUCCESSFUL SAVE INSTRUCTOR NAME IN SESSION VARIABLE (SEE BELOW)
					//HttpSession session = request.getSession();
					//session.setAttribute("first_name", first_name);
					RequestDispatcher rd = request.getRequestDispatcher("/Student.jsp");
					rd.forward(request, response);
				//ELSE KEEP ON LOGIN PAGE AND SHOW ERROR MESSAGE (BASICALLY HW3)
					//RequestDispatcher rd = request.getRequestDispatcher("/StudentLogin.jsp");
					//rd.forward(request, response);
	}
}

