package Model;

import java.util.HashSet;

public class Assistant extends StudyWorker {

    public Assistant(String id, String name, String address, String phone, String mail, String userName, String password, String role, Boolean status) {
        super(id, name, address, phone, mail, userName, password, status);
    }

    public Course getCurrentcourse(){return null;}
    public HashSet<Course> getAllCourses(){return null;}
    public String getRole(){ return "Assistant";}
}
