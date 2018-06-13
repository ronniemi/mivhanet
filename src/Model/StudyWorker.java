package Model;

import java.util.HashSet;

public abstract class StudyWorker extends User{

    public StudyWorker(String id, String name, String address, String phone, String mail, String userName, String password, Boolean status) {
        super(id, name, address, phone, mail, userName, password, status);
    }

    public abstract Course getCurrentcourse();
    public abstract HashSet<Course> getAllCourses();
}
