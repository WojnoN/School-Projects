package finalExam;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtils.DButil;
import Beans.EnrollBean;

@WebServlet("/enrollClassServlet")

public class registerClass extends HttpServlet{

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			DButil db = new DButil();
		    String uID = "cst4713";
		    String uPassword = "password1";
		    
		    db.connectDB(uID, uPassword);
		    
		    String SSN = (String)session.getAttribute("ssn");
		    String courseID = request.getParameter("course");
		    String grade = request.getParameter("grade");
		    String courseTitle = "";
		    String tester = null;
		    
		    try {
		    courseTitle = db.getCourseTitle(courseID);
		    tester = db.getCourse(SSN, courseID);
		    } catch(SQLException | ClassNotFoundException ex){
				ex.getMessage();
				ex.printStackTrace();
			}
		    
		    EnrollBean enrollBean = new EnrollBean(courseID,courseTitle,grade);
		    
		    if(SSN == null || SSN.length() < 9 || SSN.length()>9){
		    	SSN = "0000";
		    }
		    
		    enrollmentService service = new enrollment();	    
		   

		    String address="";
		    if (!tester.trim().equals("") || tester.equals(null))
		    	address = "./enrollRegisterError.jsp";
		   
		    else {
		    	service.enrollClass(enrollBean, SSN);
		    	address = "./myRegist.jsp";
		    }
		  
		    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		    dispatcher.forward(request, response);		
			
		}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}
