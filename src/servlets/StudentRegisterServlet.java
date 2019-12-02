package servlets;

import classes.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class StudentRegisterServlet
 */
@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {

//	TEST TO SEE IF THE SQL WORKS
//	public static void main(String[] args){
//		System.out.println("Is this working");
//		String username = "aagamva@gmail.com";
//		String password = "123";
//		String first_name = "Aagam";
//		String last_name = "Vadecha";
//		String confirmpw = "1234";
//		if(confirmpw.equals(password)) {
//			System.out.println("GETS HERE");
//			if (UserManager.register(username, password, first_name, last_name, 1)) {
//				ArrayList<String> temp = UserManager.login(username, password,1);
//				System.out.println("id: " + temp.get(0) + "\nfName: " + temp.get(3) + "\nlName: " + temp.get(4) + "\nusername: " + temp.get(1)
//						+ "\npassword: " + temp.get(2) + "\nStrikes: " + temp.get(5));
//			}
//			else {
//				System.out.println("Registration failed bc user probably already exists");
//			}
//		}
//		else {
//			System.out.println("passwords don't match");
//		}
//
//	}

	private static final long serialVersionUID = 1L;
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get username and password from form
//		System.out.println("Is this working)");
	    HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String confirmpw = request.getParameter("confirmpassword");
		String next = "/Student.jsp";
		if(username.matches("^(.+)@(.+)(.com|.edu|.net)$") ) {
			if (confirmpw.trim().equals(password.trim())) {
//			System.out.println("GETS HERE");
				if (UserManager.register(username, password, first_name, last_name, 1)) {
					ArrayList<String> temp = UserManager.login(username, password, 1);
					session.setAttribute("userType", "student");
					session.setAttribute("id", temp.get(0));
					session.setAttribute("first_name", temp.get(3));
					session.setAttribute("last_name", temp.get(4));
					session.setAttribute("username", temp.get(1));
					session.setAttribute("password", temp.get(2));
					session.setAttribute("strikes", temp.get(5));
					RequestDispatcher rd = request.getRequestDispatcher("/Student.jsp");
					rd.forward(request, response);

				} else {
					next = "/StudentRegister.jsp";
					//TODO - username already exists in db
				}
			} else {
				next = "/StudentRegister.jsp";
				//TODO - password doesn't match
			}
		}else {
			next = "/StudentRegister.jsp";
			//TODO - username is not an email
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);

		try {
		    dispatch.forward(request, response);
		} catch(IOException | ServletException e) {
		    e.printStackTrace();
		}
		// TODO - ERROR MESSAGE
	}
}
