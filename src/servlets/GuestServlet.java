package servlets;

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
 * Servlet implementation class GuestServlet
 */
@WebServlet("/GuestServlet")
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String course_name = request.getParameter("course_list");
		System.out.println("Course name" + course_name);
		
		HttpSession session = request.getSession();
		String nextPage = (String) session.getAttribute("nextPage");
	    session.setAttribute("courseName", course_name);
	    
	    
	    String test_course = (String) session.getAttribute("courseName");
	    System.out.println(test_course);
	    
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

	
	//GET ALL THE COURSE
	public static ArrayList <String> getCourses()
	{
		ArrayList <String> course_list= new ArrayList<String>(); 
		
		course_list.add("1");
		course_list.add("2");
		//GET ALL COURSES FROM DTABASE AND ADD TO COURSE_LIST
		return course_list;
	}
	
	//GET QUEUE NUMBER
	public static int getQueue()
	{
		int number = 6;
		return  number;
	}
	
	//GET INSTRUCTOR COURSES
	public static ArrayList <String> getInstructorCourses()
	{
		ArrayList <String> course_list= new ArrayList<String>(); 
		
		course_list.add("1");
		course_list.add("2");
		//GET ALL COURSES FROM DATABASE AND ADD TO COURSE_LIST
		return course_list;
	}
	
	// ADD TO INSTRUCTOR COURSES
	
	//GET INSTRUCTOR COURSES
		public static ArrayList <String> getInstructorCourses(String name)
		{
			ArrayList <String> course_list= new ArrayList<String>(); 
			//GET INSTRUCTOR ID FROM NAME, THEN GET ALL COURSES THAT INSTRUCTOR TEACHES
			course_list.add("CSCI201");
			course_list.add("CSCI270");
			//GET ALL COURSES FROM DATABASE AND ADD TO COURSE_LIST
			return course_list;
		}
	
	//SHOW CALENDAR
	public static void DisplayCalendar(String courseName)
	{
		//FIND COURSEID from CCOURSENAME AND FIND OFFICE HOUR TABLE
		//YALL DECIDE RETURN TYPE
		//COULD BE VECTOR/OH OBJECT/ARRAYLIST
		//FLORA AND I WILL PARSE/DISPLAY WHATEVER YOU DECIDE
	}
	
	
	public static void AddToAllCourses(String courseName)
	{
		
		
	}
	
	public static void AddToInstructorCourses(String courseName)
	{
		
		
	}
	
}
