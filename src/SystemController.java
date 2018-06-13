import javafx.util.Pair;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;

public class SystemController {
    emailNotifer notifer;
    LoggerError loggerError;
    LoggerActions loggerActions;
    HashSet<Course> courses;
    User currentUser;
    HashSet<User> allUsers;

    public void createCourseInSemester(String courseID, semester sem, String year, HashSet<String> studentsID, HashSet<String> lecturerID, HashSet<String> assistantID){};

    public HashSet<Course> getAllCourses() {
        return courses;
    }

    public HashSet<semester> getAllSemesters() {return null;}
    public HashSet<String> getAllYears() {return null}
    public HashSet<StudyWorker> getAllStudyWorkers() {};
    public Student getStudent(String studentID){};
    public HashSet<Student> getAllStudents() {};
    public User getUser(String userID){};
    public HashSet<Assistant> getAllAssistants() {};
    public HashSet<Lecturer> getAllLecturers() {};
    public void createCourse(String name){};
    public String generateCourseID(){};
    public void updateSylabus(String sylabus, String courseID, semester sem, String year){};
    public void createExamMoed(String courseID, semester sem, String year, moed m, Date date){};
    public void addQuestionToExamMoed(String courseID, semester sem, String year, String questionID){};
    public void printExamMoed(String courseID, semester sem, String year, moed m){};
    public void display(String message){};
    public void createStudentSolution(String courseID, semester sem, String year, moed m, String studentID){};
    public void addOptionToStudentSolution(String courseID, semester sem, String year, moed m, String studentID, Map<String, String > solution){};
    public HashSet<Student> getStudentInCourseInSemester(String courseID, semester sem, String year, String studentID){};
    public HashSet<Student> getAllStudentOfCourseInSemester(String courseID, semester sem, String year){};
    public HashSet<ExamMoed> getAllExamMoed(String courseID, semester sem, String year){};
    public void createNewQuestion(String courseID, String questionBody, int questionDificulty, long questionTime){};
    public void addOptionToQuestion(String courseID, String questionID, String optionBody, boolean isRight){};
    public void factor(String courseID, semester sem, String year, moed m, int factor){};
    public void updateStudentGrade(String courseID, semester sem, String year, moed m, String studentID, int grade){};
    public int getStudentGrade(String courseID, semester sem, String year, moed m, String studentID){};
    public void confirmExam(String courseID, semester sem, String year, moed m, String lecturerID){};
    public HashSet<Question> getAllQuestionInCourse(String courseID){};
    public void editQuestion(String courseID, semester sem, String year, String questionID, String questionBody){};
    public void deleteQuestion(String courseID, String questionID){};
    public void editQuestionTime(String courseID, String questionID, long time){};
    public void rankQuestion(String courseID, String questionID, int rank){};
    public void createNewComment(String courseID, String questionID, String commentBody){};
    public void editOption(String courseID, String questionID, String optionBody){};
    public void addStudyWorker(String ID, String name, String address, String phoneNumber, String email){};
    public Pair<String,String> generateUsernameAndPassword(){};
    public void login(String userName, String password){};
    public void changePassword(String userName, String oldPassword, String newPassword){};
    public void createStudent(String studentID){};


}