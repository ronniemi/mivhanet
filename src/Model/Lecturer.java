package Model;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.util.HashSet;

public class Lecturer extends StudyWorker {

    public Lecturer(String id, String name, String address, String phone, String mail, String userName, String password, Boolean status) {
        super(id, name, address, phone, mail, userName, password, status);
    }

    public boolean isManager(String courseID) {
        //select from courseInSemester MangagerId where coursid = courseid
        return false;
    }

    public Course getCurrentcourse(){return null;}
    public HashSet<Course> getAllCourses(){return null;}
    public String getRole(){return "Lecturer";}
}
