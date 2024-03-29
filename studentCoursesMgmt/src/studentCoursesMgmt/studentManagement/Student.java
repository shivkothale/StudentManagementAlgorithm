package studentCoursesMgmt.studentManagement;

import java.util.List;

public class Student {

    private String id;
    private List<Character> coursesAllocated;
    private double satisfactionRating=0;
    public double getSatisfactionRating() {
        return satisfactionRating;
    }
    public void setSatisfactionRating(double rating) {
        this.satisfactionRating = rating;
    }
    public String getId() {
        return id;
    }
    public void setId(String pref) {
        this.id = pref;
    }
    public List<Character> getCoursesAllocated() {
        return coursesAllocated;
    }
    public void setCoursesAllocated(List<Character> coursesAllocated) {
        this.coursesAllocated = coursesAllocated;
    }
    @Override
    public String toString() {
        return id+":"+coursesAllocated+"::SatisfactionRating="+String.format("%.2f",satisfactionRating);
    }
}
