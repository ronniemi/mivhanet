package Model;

import java.util.HashMap;
import java.util.HashSet;

public class Course {
    String name;
    String id;
    HashSet<CourseInSemester> courses;
    HashMap<String, Question> Questions;
    MySystemModel controller;

    public Course(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public CourseInSemester getCourseInSemester(semester sem, String year){return null;};

    public HashSet<CourseInSemester> getAllCoursesInSemester() {
        return courses;
    }

    public Question getQuestion(String questionID){ return Questions.get(questionID);}

    public HashMap<String, Question> getAllQuestions() {
        return Questions;
    }

    public HashMap<String, StudyWorker> getAllCourseStudyWorkers(){return null;}

<<<<<<< HEAD
    public void deleteQuestion(String questionID){}
=======
    public void deleteQuestion(String questionID){};

    PreparedStatement statement = conn.prepareStatement("SELECT userName, password FROM user WHERE Username =?");
        statement.setString(1, username);
    ResultSet rs=statement.executeQuery();

    String res="";
        while(rs.next())
    {
        res+="#ID: "+rs.getString("commentID") +"- Writer: "+ rs.getString("writerID") +"\nBody: "+ rs.getString("body") +"\n";
    }
        if(res.equals(""))
                return "No Comments";
        return res;
}
>>>>>>> 30453c29ca4b297149d262956f0ad01359cbad0e
}
