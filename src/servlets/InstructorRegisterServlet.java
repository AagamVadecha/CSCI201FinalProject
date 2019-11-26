package servlets;

import classes.UserManager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InstructorRegisterServlet
 */
@WebServlet("/InstructorRegisterServlet")
public class InstructorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get username and password from form
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String confirmpw = request.getParameter("confirmpassword");

		if(confirmpw.trim().equals(password.trim())) {
			if (UserManager.register(username, password, first_name, last_name, 2)) {
				ArrayList<String> temp = UserManager.login(username,password,2);
				session.setAttribute("userType", "instructor");
				session.setAttribute("id", temp.get(0));
				session.setAttribute("first_name", temp.get(3));
				session.setAttribute("last_name", temp.get(4));
				session.setAttribute("username",temp.get(1));
				session.setAttribute("password",temp.get(2));
				RequestDispatcher rd = request.getRequestDispatcher("/Instructor.jsp");
				rd.forward(request, response);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/InstructorRegister.jsp");
		rd.forward(request, response);
	}
}
