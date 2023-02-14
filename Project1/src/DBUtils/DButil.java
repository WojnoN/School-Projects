package DBUtils;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;

public class DButil {
	private static Connection connection;
	private ResultSet resultset;
	
	// Open Connection to database
	public void connectDB(String ID, String password){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("JDBC Driver loaded. Connecting to database....");
			connection = DriverManager.getConnection("jdbc:sqlserver://s16988308.onlinehome-server.com:1433;"
					+ "databaseName=CUNY_DB;integratedSecurity=false;", ID,password);
			System.out.println("Database Connected.");
		}catch(ClassNotFoundException | SQLException ex){
			ex.printStackTrace();					
		}
	}
	
	// Run Query to get result set
	public ResultSet getQuery(String query) throws SQLException, ClassNotFoundException {
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultset;
	}	

	public String getCourses() throws SQLException, ClassNotFoundException {
		String resultList="";
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT  courseID, title, numOfCredits FROM course;");
			while (resultset.next())
			{
				resultList= resultList + "<li>" + resultset.getString(1) + "\t" 
						+ resultset.getString(2) + "\t" + resultset.getString(3) + "</li>\n";			
			}
			
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultList;
	}
	
	public String getCourse(String SSN, String courseID) throws SQLException, ClassNotFoundException {
		String result="";
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT * FROM Enrollment where ssn = "+SSN+" and courseID = '"+courseID+"';");
			while (resultset.next())
			{
				result = resultset.getString(1) + " " 
						+ resultset.getString(2);			
			}
			
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public String getCourseTitle(String courseID) throws SQLException, ClassNotFoundException {
		String result="";
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT title FROM Course where courseID = '"+courseID+"';");
			while (resultset.next())
			{
				result = resultset.getString(1);			
			}
			
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public String getCourses(String SSN) throws SQLException, ClassNotFoundException {
		String resultList="";
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT Enrollment.courseId,  course.title, enrollment.grade" +
					" FROM enrollment join Course on course.courseID=enrollment.courseId where enrollment.ssn = "
					+ SSN + ";");
			while (resultset.next())
			{
				resultList= resultList + "<li>" + resultset.getString(1) + "\t" 
						+ resultset.getString(2) + "\t" + resultset.getString(3) + "</li>\n";			
			}
			
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultList;
	}
	public ResultSet getCoursesSet(String SSN) throws SQLException, ClassNotFoundException {

		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT Enrollment.courseId,  course.title, enrollment.grade" +
					" FROM enrollment join Course on course.courseID=enrollment.courseId where enrollment.ssn = "
					+ SSN + ";");
			
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultset;
	}
	
	public ResultSet getCoursesSet() throws SQLException, ClassNotFoundException {

		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("select courseID,title from course;");
			
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultset;
	}
	
	// Insert values into database
	public void enrollClass(String classID, String classTitle, String grade,String SSN)throws SQLException, ClassNotFoundException {
		try{
			
			String localtime = LocalDate.now() + " " + LocalTime.now();
			//connectDB();
			Statement statement = connection.createStatement();
			System.out.println("INSERT into enrollment (ssn,courseId,dateRegistered,grade)"
					+ "VALUES("+SSN+ ",'"+classID + "','" +LocalDate.now()+ "','" +grade+ "');");
			statement.executeUpdate("INSERT into enrollment VALUES("+SSN+",'"+classID + "','" +localtime+ "','" +grade+ "');");
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
	}
	
	public void dropClass(String classID,String SSN)throws SQLException, ClassNotFoundException {
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE from enrollment where ssn = " + SSN + " and courseID = '" + classID + "';");
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
	}
	
public void updateValues(String table, String query)throws SQLException, ClassNotFoundException {
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
	}
	
public ResultSet getStudent(String SSN) throws SQLException, ClassNotFoundException {
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT * FROM Students where ssn = "+ SSN + ";");
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		return resultset;
	}	

	
	// Closes database connection
	public void closeConn() throws SQLException{

		connection.close();
	}
}