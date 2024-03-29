package studentCoursesMgmt.studentManagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import studentCoursesMgmt.util.FileProcessor;
import studentCoursesMgmt.util.Results;

public class StudentManagement implements IStudentManagement{ 
    /**
     * This method is used to assign courses to students according to their preferences.
     * It internally calls the manageCourses method which actually does the allocation of the courses.
     * @param studentPrefs It is a FileProcessor object that runs reads the input file Line by Line. 
     * @param studentPref   It is a map that has the courses data in it. where key is the course and
     *                        value is the array of capacity and the timing.
     */
    @Override
    public void assignCourses(FileProcessor studentPrefs, Map<Character, int[]> map) {
        Scanner sc=studentPrefs.getFileReader();
        
       
        while(sc.hasNextLine()){
            String[]studentPref=studentPrefs.readLine(sc);
            
            manage(map,studentPref);
        }
    }

    /**
     * Manage method is the method that allocated the courses to students
     * by checking each preference with each key in the map.
     * @param map   It is a map that has the courses data in it. where key is the course and
     *              value is the array of capacity and the timing.
     * @param studentPrefs
     */
    private void manage(Map<Character, int[]> map, String[] studentPrefs) {
        Set<Integer> set=new HashSet<>();
        int counter=0;
        Results results=new Results();
        Student student=new Student();
        List<Character> subjectsAssigned=new ArrayList<>();
        int satisfactionRating=0;
        student.setId(studentPrefs[0]);
        for(int i=1;i<studentPrefs.length;i++){
            if(counter>=3){break;}
            char key=studentPrefs[i].charAt(0);
            int[] temp=null;
            try{
                temp=map.get(key);
            }catch(NullPointerException e){
                results.addError(studentPrefs[0]+" : Course "+key +" is full");
            }
            int capacity=temp[0];
            int time=temp[1];
            if(capacity!=0){
                if(!set.contains(time)){
                set.add(time);
                counter++;
                capacity--;
                satisfactionRating=satisfactionRating+(10-i);
                map.put(key,new int[]{capacity,time});
                subjectsAssigned.add(key);
                }else{
                    results.addConflict(studentPrefs[0]+" : For the course "+key +" timings are clashing with other classes");
                    continue;
                    
                }
            }else if(capacity==0){
                results.addError(studentPrefs[0]+" : Course "+key +" is full");
                continue;
            }
        }
        double rating=0;
        if(satisfactionRating>1){
            rating=(double)satisfactionRating/3;
        }else rating=0;
        student.setCoursesAllocated(subjectsAssigned);
        student.setSatisfactionRating(rating);
        results.addToResultList(student);
       
    }    
}