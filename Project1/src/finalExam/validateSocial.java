package finalExam;

import java.sql.ResultSet;
import java.sql.SQLException;
import Beans.Student;
import DBUtils.DButil;

public class validateSocial implements SSNValidateService{

	public validateSocial() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Student validateSSN(String SSN) {
		String SSNconfirm = "";
	
		try {
			DButil db = new DButil();
			db.connectDB("cst4713", "password1");
			//System.out.println("Database Connected");
			
	    	ResultSet resultset = db.getStudent(SSN);
	    	//System.out.println("Result Set Recovered");
	    	//System.out.println(resultset.getCharacterStream(1));
	    	resultset.next();
	    	Student studentBean = new Student(resultset.getString(1), resultset.getString(2), resultset.getString(3),
	    			resultset.getString(4),resultset.getString(5), resultset.getString(6),resultset.getString(7),
	    			resultset.getString(8),resultset.getString(9));		
	    	while(resultset.next()){
	    		System.out.println(resultset.getString(1)+" "+resultset.getString(2));
	    	}
			if (studentBean.getSsn().equals(SSN)){
				SSNconfirm = studentBean.getSsn();
			}
			resultset.close();
			db.closeConn();
			
			if (SSNconfirm.equals(SSN)) {
				System.out.println("Student found.");
				return(studentBean);}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.print("Exception Thrown");
			
		}
			System.out.println("Student Not found.");
			return(null);
		}
	}


