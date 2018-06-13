import java.util.HashSet;

public class Lecturer extends StudyWorker {
    HashSet<CourseInSemester> teaches;
    HashSet<CourseInSemester> manages;
    HashSet<ExamMoed> examsApproved;
    HashSet<ExamMoed> examsWritten;

    public boolean isManager(String courseID) {return false;}
}
