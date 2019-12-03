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
 * Servlet implementation class InstructorLoginServlet
 */
@WebServlet("/InstructorLoginServlet")
public class InstructorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get username and password from form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String next = "/Instructor.jsp";
		if(UserManager.verify(username,password,2)){
			ArrayList<String> temp = UserManager.login(username,password,2);
			if (!temp.isEmpty()) {
    			session.setAttribute("userType", "instructor");
    			session.setAttribute("id", temp.get(0));
    			session.setAttribute("first_name", temp.get(3));
    			session.setAttribute("last_name", temp.get(4));
    			session.setAttribute("username",temp.get(1));
    			session.setAttribute("hashedPassword",temp.get(2));
			}else{
				next ="/InstructorLogin.jsp";
				session.setAttribute("error", "Unfortunately, this combination of username and password does not exist in our database.");
				// TODO - USERNAME AND PASSWORD DO NOT EXIST IN DB
			}
		}else{
			next ="/InstructorLogin.jsp";
			session.setAttribute("error", "Unfortunately, you haven't registered yet with this email.");
			//TODO - USERNAME IS NOT IN DB
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
        
        try {
            dispatch.forward(request, response);
        } catch(IOException | ServletException e) {
            e.printStackTrace();
        }
	}
}

