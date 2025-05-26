import java.util.*;

public class StudentCourses {
    private Map<String, Map<String, Integer>> semesterCourses;

    public StudentCourses() {
        semesterCourses = new LinkedHashMap<>();
    }

    public void addCourse(String semester, String courseName, int marks) {
        semesterCourses.putIfAbsent(semester, new LinkedHashMap<>());
        semesterCourses.get(semester).put(courseName, marks);
    }

    public void displayCourses() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("\n" + semester + " Courses:");
            Map<String, Integer> courses = semesterCourses.get(semester);
            for (String course : courses.keySet()) {
                System.out.println(course + ": " + courses.get(course) + " marks");
            }
        }
    }

    // Test via main
    public static void main(String[] args) {
        StudentCourses courses = new StudentCourses();

        courses.addCourse("Semester 1", "Operating-System", 85);
        courses.addCourse("Semester 1", "Python", 78);
        courses.addCourse("Semester 2", "DSA", 92);
        courses.addCourse("Semester 2", "FullStack", 88);

        courses.displayCourses();
    }
}
