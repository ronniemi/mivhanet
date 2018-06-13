package Model;

import javafx.util.Pair;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;

public class SystemModel extends Observable { // notifyObservers("");
    emailNotifer notifer;
    LoggerError loggerError;
    LoggerActions loggerActions;
    HashSet<Course> courses;
    User currentUser;
    HashSet<User> allUsers;


    java.util.Random rand = new java.util.Random();
    String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    public void createCourseInSemester(String courseID, semester sem, String year, HashSet<String> studentsID, HashSet<String> lecturerID, HashSet<String> assistantID){};

    public HashSet<Course> getAllCourses() {
        return courses;
    }

    public HashSet<semester> getAllSemesters() {return null;}
    public HashSet<String> getAllYears() {return null;}

    public HashSet<StudyWorker> getAllStudyWorkers() {return null;}

    public Student getStudent(String studentID){return null;}

    public HashSet<Student> getAllStudents() {return null;}

    public User getUser(String userID){
        String query = "SELECT FROM user * WHERE ID='" +userID + "'";
        return null; //return user
    }
    public HashSet<Assistant> getAllAssistants() {return null;}

    public HashSet<Lecturer> getAllLecturers() {return null;}

    public void createCourse(String name){}

    public String generateCourseID(){return null;}

    public void updateSylabus(String sylabus, String courseID, semester sem, String year){}

    public void createExamMoed(String courseID, semester sem, String year, moed m, Date date){}

    public void addQuestionToExamMoed(String courseID, semester sem, String year, String questionID){}

    public void printExamMoed(String courseID, semester sem, String year, moed m){}

    public void display(String message){}

    public void createStudentSolution(String courseID, semester sem, String year, moed m, String studentID){}

    public void addOptionToStudentSolution(String courseID, semester sem, String year, moed m, String studentID, Map<String, String > solution){}

    public HashSet<Student> getStudentInCourseInSemester(String courseID, semester sem, String year, String studentID){return null;}

    public HashSet<Student> getAllStudentOfCourseInSemester(String courseID, semester sem, String year){return null;}

    public HashSet<ExamMoed> getAllExamMoed(String courseID, semester sem, String year){return null;}

    public void createNewQuestion(String courseID, String questionBody, int questionDificulty, long questionTime){}

    public void addOptionToQuestion(String courseID, String questionID, String optionBody, boolean isRight){}

    public void factor(String courseID, semester sem, String year, moed m, int factor){}

    public void updateStudentGrade(String courseID, semester sem, String year, moed m, String studentID, int grade){}

    public int getStudentGrade(String courseID, semester sem, String year, moed m, String studentID){return 0;}

    public void confirmExam(String courseID, semester sem, String year, moed m, String lecturerID){}

    public HashSet<Question> getAllQuestionInCourse(String courseID){return null;}

    public void editQuestion(String courseID, semester sem, String year, String questionID, String questionBody){}

    public void deleteQuestion(String courseID, String questionID){}

    public void editQuestionTime(String courseID, String questionID, long time){}

    public void rankQuestion(String courseID, String questionID, int rank){}

    public void createNewComment(String courseID, String questionID, String commentBody){}

    public void editOption(String courseID, String questionID, String optionBody){}

    public Pair<String,String> createNewUser(String ID, String name, String address, String phoneNumber, String email, String role){
        if(currentUser.getRole().equals("Secretary")){
            String username = generateUsername();
            String password = generatePassword();
            // query to enter user
            return new Pair<>(username, password);
        }
        else
            return null;
    }

    private String generateUsername(){
        StringBuilder builder = new StringBuilder();
        //get from db list of all usernames
        HashSet<String> usernames = new HashSet<String>();

        while(builder.toString().length() == 0) {
            for(int i = 0; i < 8; i++)
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            if(usernames.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    private String generatePassword(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 10; i++)
            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
        return builder.toString();
    }

    public void login(String userName, String password){
        //query to user table check uf username and password correct
        //currentUser = new User()
        //currenyUser.changestatuse();
        notifyObservers("loogedIn");
        notifyObservers("errorLoggedIn");
    }

    public void changePassword(String userName, String oldPassword, String newPassword){}

    public void createStudent(String studentID){}

}
