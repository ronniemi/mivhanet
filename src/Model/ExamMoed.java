package Model;

import java.util.Date;
import java.util.HashSet;

public class ExamMoed {
    Date date;
    boolean approved;
    int factor;
    moed moed;
    HashSet<StudentSolution> solutions;
    HashSet<Score> scores = new HashSet<>(20);
    CourseInSemester course;
    Secretary secretary;
    Lecturer approvedBy;
    Lecturer writtenBy;

    public ExamMoed(Date date, moed m) {
        this.date = date;
        this.moed = m;
    }

    public int getNumberOfQuestions() {return 0;}
    public void addQuestion(Question question){}
    public HashSet<Question> getAllQuestionInExamMoed(){return null;}
    public StudentSolution getStudentSolution(String studentID){return null;}
    public void addStudentSolutionToExamMoed(StudentSolution ss) {}
    public void factor(int factor){}
    public void confirmExam(Lecturer lecturer){}

}
