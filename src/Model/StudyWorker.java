package Model;

import java.util.HashSet;

public class StudyWorker extends User{

    HashSet<Comment> commentsWritten;
    HashSet<Question> questionsWritten;

    public Course getCurrentcourse(){return null;}
    public HashSet<Course> getAllCourses(){return null;}
    public String getRole(){return null;}
}
