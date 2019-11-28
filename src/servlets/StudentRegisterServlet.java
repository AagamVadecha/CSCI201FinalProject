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
 * Servlet implementation class StudentRegisterServlet
 */
@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get username and password from form
	    	HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String confirmpw = request.getParameter("confirmpassword");
		String next = "/Student.jsp";
		if(confirmpw.trim().equals(password.trim())) {
			if (UserManager.register(username, password, first_name, last_name, 1)) {
				ArrayList<String> temp = UserManager.login(username, password,1);
				session.setAttribute("userType", "student");
				session.setAttribute("id", temp.get(0));
				session.setAttribute("first_name", temp.get(3));
				session.setAttribute("last_name", temp.get(4));
				session.setAttribute("username", temp.get(1));
				session.setAttribute("password", temp.get(2));
				session.setAttribute("strikes", temp.get(5));
//				RequestDispatcher rd = request.getRequestDispatcher("/Student.jsp");
//				rd.forward(request, response);
				
			}
			else {
			    next = "/StudentRegister.jsp";
			}
		}
		else {
		    next = "/StudentRegister.jsp";
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
        
		try {
		    dispatch.forward(request, response);
		} catch(IOException e) {
		    e.printStackTrace();
		} catch (ServletException e) {
		    e.printStackTrace();
		} 
			// TODO - ERROR MESSAGE 
	}
}
