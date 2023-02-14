package finalExam;

import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.EnrollBean;
import DBUtils.DButil;

public class enrollment implements enrollmentService {

	@Override
	public String getMyClasses(String SSN) {
		String result = "";
		DButil db = new DButil();
		
		try {
			db.connectDB("CST4713", "password1");
			ResultSet resultset = db.getCoursesSet(SSN);
			while (resultset.next())
			{
				result += "<tr><td>" + resultset.getString(1) + "</td>"
						+ "<td>" + resultset.getString(2) + "</td>"
						+ "<td>" + resultset.getString(3) + "</td></tr>";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.print("Exception Thrown");
			
		}
		
		if (result.equals("") || result == null)
			return null;
		else return result;
	}

	@Override
	public void enrollClass(EnrollBean enrollBean,String SSN) {
		String result = "";
		DButil db = new DButil();
		
		try {
			db.connectDB("CST4713", "password1");
			db.enrollClass(enrollBean.getCourseID(), enrollBean.getTitle(), enrollBean.getGrade(),SSN);
			db.closeConn();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.print("Exception Thrown");
			
		}
	}
	
	public void dropClass(String SSN, String classID){
		String result = "";
		DButil db = new DButil();
		
		try {
			db.connectDB("CST4713", "password1");
			String test = getMyClasses(SSN);
			
			
			if(test.contains(classID) && !(test.equals(null))){
				db.dropClass(classID, SSN);
			}
			
			db.closeConn();
	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.print("Exception Thrown");
			
		}
	}


	

}
