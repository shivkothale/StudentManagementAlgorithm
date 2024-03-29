package studentCoursesMgmt.studentManagement;

import java.util.Map;

import studentCoursesMgmt.util.FileProcessor;

public interface IStudentManagement {
    /**
     * @param studentPrefs
     * @param map
     */
    public void assignCourses(FileProcessor studentPrefs, Map<Character, int[]> map);
}
