package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InstructorAddCourse
 */
@WebServlet("/InstructorAddCourse")
public class InstructorAddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newCourse = request.getParameter("new");
		GuestServlet.AddToInstructorCourses(newCourse);
		GuestServlet.AddToAllCourses(newCourse);
		System.out.println(newCourse);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Instructor.jsp");
		dispatcher.forward(request, response);	
	}

}
