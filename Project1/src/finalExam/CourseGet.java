package finalExam;

import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.ClassesBean;
import DBUtils.DButil;

public class CourseGet implements getCoursesService {

	@Override
	public String getCourses() {
		String result = "";
		DButil db = new DButil();
		
		try {
			db.connectDB("CST4713", "password1");
			ResultSet resultset = db.getCoursesSet();
			while (resultset.next())
			{
				ClassesBean classBean = new ClassesBean(resultset.getString(1),resultset.getString(2));
				result += "<option value=\"" + classBean.getCourseID() +"\">" + classBean.getCourseID() + "</option>";
				
			}
			
			// System.out.println(result);
			db.closeConn();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.print("Exception Thrown");
			
		}
		
		if (result.equals("") || result == null)
			return null;
		else return result;
	}

	
}
