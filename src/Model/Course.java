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

    public void deleteQuestion(String questionID){}
}
