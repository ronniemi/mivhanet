package Model;

import java.sql.*;

import javafx.util.Pair;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;

public class MySystemModel extends Observable {
    public static Connection conctn;

    public MySystemModel(){
        try {
            Class.forName("org.sqlite.JDBC");
            conctn = DriverManager.getConnection("jdbc:sqlite:courseDB.db");
        } catch (Exception e) {
            return;
        }
    }

    emailNotifer notifer;
    LoggerError loggerError;
    LoggerActions loggerActions;
    HashSet<Course> courses;
    public User currentUser;
    HashSet<User> allUsers;


    java.util.Random rand = new java.util.Random();
    String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    public void createCourseInSemester(String courseID, semester sem, String year, HashSet<String> studentsID, HashSet<String> lecturerID, HashSet<String> assistantID) {}
    public HashSet<Course> getAllCourses() {
        HashSet<Course> courses = new HashSet<Course>();
        try{
            PreparedStatement statement = conctn.prepareStatement("SELECT * FROM course");
            ResultSet rs = statement.executeQuery();
            while(rs.next())
                courses.add(new Course(rs.getString("name"), rs.getString("ID")));
        }
        catch(Exception e){}
        return courses;
    }

    public HashSet<semester> getAllSemesters() {
        return null;
    }

    public HashSet<String> getAllYears() {
        return null;
    }

    public HashSet<StudyWorker> getAllStudyWorkers() {
        return null;
    }

    public Student getStudent(String studentID) {
        return null;
    }

    public HashSet<Student> getAllStudents() {
        return null;
    }

    public User getUser(String userID) {
        String query = "SELECT FROM user * WHERE ID='" + userID + "'";
        return null; //return user
    }

    public HashSet<Assistant> getAllAssistants() {
        return null;
    }

    public HashSet<Lecturer> getAllLecturers() {
        return null;
    }

    public void createCourse(String name) {
    }

    public String generateCourseID() {
        return null;
    }

    public void updateSylabus(String sylabus, String courseID, semester sem, String year) {
    }

    public void createExamMoed(String courseID, semester sem, String year, moed m, Date date) {
    }

    public void addQuestionToExamMoed(String courseID, semester sem, String year, String questionID) {
    }

    public void printExamMoed(String courseID, semester sem, String year, moed m) {
    }

    public void display(String message) {
    }

    public void createStudentSolution(String courseID, semester sem, String year, moed m, String studentID) {
    }

    public void addOptionToStudentSolution(String courseID, semester sem, String year, moed m, String studentID, Map<String, String> solution) {
    }

    public HashSet<Student> getStudentInCourseInSemester(String courseID, semester sem, String year, String studentID) {
        return null;
    }

    public HashSet<Student> getAllStudentOfCourseInSemester(String courseID, semester sem, String year) {
        return null;
    }

    public HashSet<ExamMoed> getAllExamMoed(String courseID, semester sem, String year) {
        return null;
    }

    public void createNewQuestion(String courseID, String questionBody, int questionDificulty, long questionTime) {
    }

    public void addOptionToQuestion(String courseID, String questionID, String optionBody, boolean isRight) {
    }

    public void factor(String courseID, semester sem, String year, moed m, int factor) {
    }

    public void updateStudentGrade(String courseID, semester sem, String year, moed m, String studentID, int grade) {
    }

    public int getStudentGrade(String courseID, semester sem, String year, moed m, String studentID) {
        return 0;
    }

    public void confirmExam(String courseID, semester sem, String year, moed m, String lecturerID) {
    }

    public HashSet<Question> getAllQuestionInCourse(String courseID) {
        HashSet<Question> questions = new HashSet<Question>();
        try{
            PreparedStatement statement = conctn.prepareStatement("SELECT * FROM question WHERE courseID=?");
            statement.setString(1, courseID);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String id = rs.getString("ID");
                String body = rs.getString("body");
                int diff = rs.getInt("difficulty");
                String date = rs.getString("time");
                Question q = new Question(id, body, diff, date);
                questions.add(q);
            }
        }
        catch(Exception e){}
        return questions;
    }

    public void editQuestion(String courseID, semester sem, String year, String questionID, String questionBody) {
    }

    public void deleteQuestion(String courseID, String questionID) {
        if (currentUser.getRole().equals("Lecturer")) {
            try {
                PreparedStatement statement = conctn.prepareStatement("SELECT managerID FROM courseInSemester WHERE courseID=?");
                statement.setString(1, courseID);
                ResultSet rs = statement.executeQuery();
                boolean isManager = false;
                while(rs.next() && !isManager){
                    String userId = rs.getString("managerID");
                    if(userId.equals(currentUser.id))
                        isManager = true;
                }
                if(isManager){
                    statement = conctn.prepareStatement("DELETE FROM question WHERE ID=?");
                    statement.setString(1, questionID);
                    statement.execute();
                    setChanged();
                    notifyObservers("questionDeleted");
                }
                else{
                    setChanged();
                    notifyObservers("questionNotDeleted");
                }
            } catch (Exception e) {
                setChanged();
                notifyObservers("questionNotDeleted");
            }
        }
        else{
            setChanged();
            notifyObservers("questionNotDeleted");
        }

    }

    public void editQuestionTime(String courseID, String questionID, long time) {
    }

    public void rankQuestion(String courseID, String questionID, int rank) {
    }

    public void createNewComment(String courseID, String questionID, String commentBody) {
    }

    public void editOption(String courseID, String questionID, String optionBody) {
    }

    public Pair<String, String> createNewUser(String ID, String name, String address, String phoneNumber, String email, String role) {
        if (currentUser.getRole().equals("Secretary")) {
            String username = generateUsername();
            String password = generatePassword();
            try {
                PreparedStatement statement = conctn.prepareStatement("INSERT INTO user values(?, ?, ?, ?, ?, ?, ?, ?, ?) ");
                statement.setString(1, ID);
                statement.setString(2, username);
                statement.setString(3, name);
                statement.setString(4, address);
                statement.setString(5, phoneNumber);
                statement.setString(6, email);
                statement.setString(7, password);
                statement.setString(8, role);
                statement.setBoolean(9, false);
                statement.execute();

                return new Pair<>(username, password);
            } catch (SQLException e) {
                return null;
            }
        } else
            return null;
    }

    private String generateUsername() {
        StringBuilder builder = new StringBuilder();

        HashSet<String> usernames = new HashSet<String>();
        try {
            PreparedStatement statement = conctn.prepareStatement("SELECT userName FROM user");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
                usernames.add(rs.getString("userName"));

        } catch (SQLException e) {
        }

        while (builder.toString().length() == 0) {
            for (int i = 0; i < 8; i++)
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            if (usernames.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    private String generatePassword() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++)
            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
        return builder.toString();
    }

    public void login(String userName, String password) {
        try {
            System.out.println("start login");
            PreparedStatement statement = conctn.prepareStatement("SELECT * FROM user WHERE userName=? AND password=?");
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            System.out.println(rs);
            if (rs.isBeforeFirst()) {
                String id = rs.getString("ID");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String mail = rs.getString("mail");
                String role = rs.getString("role");
                if (role.equals("Assistant"))
                    currentUser = new Assistant(id, name, address, phone, mail, userName, password, true);
                else if (role.equals("Secretary"))
                    currentUser = new Secretary(id, name, address, phone, mail, userName, password, true);
                else
                    currentUser = new Lecturer(id, name, address, phone, mail, userName, password, true);

                System.out.println(currentUser.userName);
                statement = conctn.prepareStatement("UPDATE user SET loginStatus=? WHERE userName=?");
                statement.setBoolean(1, true);
                statement.setString(2, userName);
                statement.executeUpdate();
                System.out.println("logged");
                setChanged();
                notifyObservers("loggedIn");
            }

        } catch (Exception e) {
            setChanged();
            notifyObservers("errorLoggedIn");
        }
    }

    public void changePassword(String userName, String oldPassword, String newPassword) {
        try{
            PreparedStatement statement = conctn.prepareStatement("SELECT * FROM user WHERE userName=? AND password=?");
            statement.setString(1, userName);
            statement.setString(2, oldPassword);
            ResultSet rs = statement.executeQuery();
            if (rs.isBeforeFirst()){
                statement = conctn.prepareStatement("UPDATE user SET password=? WHERE userName=?");
                statement.setString(1, newPassword);
                statement.setString(2, userName);
                statement.execute();
                setChanged();
                notifyObservers("passwordChanged");
            }
            else{
                setChanged();
                notifyObservers("passwordNotChanged");
            }
        }
        catch (Exception e){
            setChanged();
            notifyObservers("passwordNotChanged");
        }
    }

    public void createStudent(String studentID) {
    }

    public void exit() {
        try {
            PreparedStatement statement = conctn.prepareStatement("UPDATE user SET loginStatus=? WHERE userName=?");
            statement.setBoolean(1, false);
            statement.setString(2, currentUser.userName);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }
}
