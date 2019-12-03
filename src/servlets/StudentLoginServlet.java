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
 * Servlet implementation class StudentLoginServlet 
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


//
//	public static void main(String[] args){
//		String username = "aagamv3122@gmail.com";
//		String password = "1234";
//		if(UserManager.verify(username,password,2)){
//			ArrayList<String> temp = UserManager.login(username,password,2);
//			// check if temp is empty - error
//			if (!temp.isEmpty()) {
//				System.out.println("id: " + temp.get(0) + "\nfName: " + temp.get(3) + "\nlName: " + temp.get(4) + "\nusername: " + temp.get(1)
//						+ "\npassword: " + temp.get(2));
//			}
//			else
//				System.out.println("It's empty bro");
//		}else{
//			System.out.println("Failed Verify");
//			// TODO - ERROR MESSAGE USERNAME AND PASSWORD DO NOT EXIST IN DB
//		}
//
//	}

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Get username and password from form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String next = "/Student.jsp";
		if(UserManager.verify(username,password,1)){
			ArrayList<String> temp = UserManager.login(username,password,1);
			// check if temp is empty - error 
			if (!temp.isEmpty()) {
    			session.setAttribute("userType", "student");
    			session.setAttribute("id", temp.get(0));
    			session.setAttribute("first_name", temp.get(3));
    			session.setAttribute("last_name", temp.get(4));
    			session.setAttribute("username",temp.get(1));
    			session.setAttribute("hashedPassword",temp.get(2));
    			session.setAttribute("strikes",temp.get(5));
			}else{
				next ="/StudentLogin.jsp";
				// TODO - USERNAME AND PASSWORD DO NOT EXIST IN DB
			}
		}else{
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

