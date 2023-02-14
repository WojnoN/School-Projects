package finalExam;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Beans.Student;

@WebServlet("/loginSSNServlet")

public class validateLogin extends HttpServlet{


	    
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    String uID = "cst4713";
		    String uPassword = "password1";
		    String SSN = request.getParameter("ssn");
		    String Name = "";
		    String pNum = "";
		    
		    if(SSN == null || SSN.length() < 9 || SSN.length()>9){
		    	SSN = "0000";
		    }
		    
		    SSNValidateService service = new validateSocial();
		    enrollmentService serviceTwo = new enrollment();
		    getCoursesService serviceThree = new CourseGet();
		    Student student = service.validateSSN(SSN);
		    HttpSession session = request.getSession();
		    
		    if (student == null)
		    	session.setAttribute("ssn", "");
		    else
		    	session.setAttribute("ssn", student.getSsn());	    
		    
		    //request.setAttribute("coursesAttribute", courseList);

		    String address="";
		    if (student == null)
		    	address = "./loginError.jsp";
		    	
		    else if (student.getSsn().trim() != "") {
		    	session.setAttribute("Name", student.getFname() + " " + student.getMname() + " " + student.getLname());
		    	session.setAttribute("pNum", student.getPhone());
		    	session.setAttribute("myCourseList", serviceTwo.getMyClasses(SSN));
		    	session.setAttribute("courseList", serviceThree.getCourses());
		    	address = "./myRegist.jsp";
		    }
		    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		    dispatcher.forward(request, response);		
			
		}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}
