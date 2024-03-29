package studentCoursesMgmt.util;

import studentCoursesMgmt.studentManagement.Student;

public interface FileDisplayInterface {
	public void addToResultList(Student student);
	public String findAverageRating();
	public void addConflict(String string);
	public void addError(String string);
	public void writeResults(String filePath);
	public void writeConflicts(String string);
	public void writeErrors(String string);
}
