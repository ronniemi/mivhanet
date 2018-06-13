import java.util.HashSet;

public class CourseInSemester {
    String sylabus;
    semester semester;
    String year;
    Course course;
    HashSet<Student> students;
    HashSet<ExamMoed> exams = new HashSet<>(3);
    HashSet<Assistant> assistants = new HashSet<>(3);
    Lecturer manager;
    HashSet<Lecturer> lecturers = new HashSet<>(5);

    public CourseInSemester(semester semester, String year) {
        this.semester = semester;
        this.year = year;
    }

    public void updateSylabus(String sylabus){}

    public void addExamMoed(ExamMoed em){}

    public ExamMoed getExamMoed(moed m){return null;}

    public HashSet<ExamMoed> getAllExamMoed() {
        return exams;
    }

    public HashSet<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(String studentID){return null;}

    public Lecturer getManager() {
        return manager;
    }

    public HashSet<StudyWorker> getAllCourseInSemesterStudyWorker(){return null;}
}

