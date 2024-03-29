package studentCoursesMgmt.util;

import java.util.ArrayList;
import java.util.List;

import studentCoursesMgmt.studentManagement.Student;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    static List<Student> resultList=new ArrayList<>();
    static List<String>conflicts=new ArrayList<>();
    static List<String>errors=new ArrayList<>();
    static double RatingsSum=0;

    @Override
    public void addToResultList(Student student){
        RatingsSum+=student.getSatisfactionRating();
        resultList.add(student);
    }

    @Override
    public String findAverageRating(){
        int numberOfStudents=resultList.size();
        double averageFinalRatings=0.00;
        if(numberOfStudents!=0){
                averageFinalRatings=RatingsSum/numberOfStudents;
        }
        return "AverageFinalRatings="+String.format("%.2f",averageFinalRatings);
    }

    @Override
    public void writeResults(String filePath) {         
        FileProcessor fp=new FileProcessor(filePath);
        for(Student s:resultList){
            fp.Write(s.toString()+"\n");
        }
        fp.Write(findAverageRating());
        fp.colseFileWriter();
    }

    @Override
    public void writeConflicts(String filePath) {
       FileProcessor sFileProcessor=new FileProcessor(filePath);
       for(String s:conflicts){
            sFileProcessor.Write(s+"\n");
        }
        sFileProcessor.colseFileWriter();
    }

    @Override
    public void addConflict(String string) {
            conflicts.add(string);
    }

    @Override
    public void addError(String string) {
        errors.add(string);
    }

    @Override
    public void writeErrors(String filePath) {
        FileProcessor sFileProcessor=new FileProcessor(filePath);
       for(String s:errors){
            sFileProcessor.Write(s+"\n");
        }
        sFileProcessor.colseFileWriter();
    }
}
