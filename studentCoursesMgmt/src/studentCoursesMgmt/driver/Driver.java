package studentCoursesMgmt.driver;

import java.util.Map;

import studentCoursesMgmt.studentManagement.IStudentManagement;
import studentCoursesMgmt.studentManagement.StudentManagement;
import studentCoursesMgmt.util.FileProcessor;
import studentCoursesMgmt.util.Results;

/**
 * @author placeholder
 *
 */
public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args){

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	    if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
		 		|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

		 	System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
		 	System.exit(0);
		 }
		
		// System.out.println("Hello World! Lets get started with the assignment");
		String coursePref="";
		String courseInfo="";
		String regResults="";
		String regConflicts="";
		String errorLog="";
		try{
			coursePref=args[0];
			courseInfo=args[1];
			regResults=args[2];
			regConflicts=args[3];
			errorLog=args[4];

		}catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Arguments missing");
		}
        FileProcessor fProcessor=new FileProcessor(courseInfo);
		Results results=new Results();
		Map<Character,int[]> map=fProcessor.readFile();
        IStudentManagement studentManagement=new StudentManagement();
		FileProcessor studentPrefs=new FileProcessor(coursePref);
		studentManagement.assignCourses(studentPrefs,map);        
		results.writeResults(regResults);
		results.writeConflicts(regConflicts);
		results.writeErrors(errorLog);
        
	}
	
    
}
