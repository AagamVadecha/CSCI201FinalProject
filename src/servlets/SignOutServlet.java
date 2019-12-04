package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignOutServlet
 */
@WebServlet("/SignOutServlet")
public class SignOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate(); //destroy a session
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/HomePage.jsp");
		try
		{
			dispatch.forward(request, response);
		}catch(IOException e){
			e.printStackTrace();
		} catch (ServletException e){
			e.printStackTrace();
		}
		//response.sendRedirect("HomePage.jsp");
		System.out.println("signed out");
	
	}
}
