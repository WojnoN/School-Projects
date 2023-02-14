package finalExam;

import Beans.EnrollBean;

public interface enrollmentService {

	public String getMyClasses(String SSN);
	public void enrollClass(EnrollBean enrollBean, String SSN);
	public void dropClass(String SSN,String classID);

}
