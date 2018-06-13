package ViewModel;

import Model.MySystemModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;

import java.net.SocketPermission;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class MyViewModel extends Observable implements Observer {
    private MySystemModel model;
    public StringProperty massage;

    public MyViewModel(MySystemModel model){
        model.addObserver(this);
        this.model = model;
        massage = new SimpleStringProperty("hello guest");
    }

    public void login(String username, String password){
        model.login(username,password);
    }

    public Pair<String,String> register(String ID, String name, String address, String phoneNumber, String email, String role){
        Pair<String,String> usernameAndPassword = model.createNewUser(ID, name, address, phoneNumber, email, role);
        return usernameAndPassword;
    }

    public void deleteQuestion(String courseID, String questionID){
        model.deleteQuestion(courseID, questionID);
    }

    public void changePassword(String username, String oldPassword, String newPassword){
        if(newPassword == null || newPassword.length() != 6) {
            setChanged();
            notifyObservers("illegalPassword");
            return;
        }
        model.changePassword(username, oldPassword, newPassword);
    }

    public void exit() {model.exit();}

    public HashSet<Model.Course> getAllCourses(){
        return model.getAllCourses();
    }

    public HashSet<Model.Question> getAllQuestionsInCourse(String courseId){
        return model.getAllQuestionInCourse(courseId);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o == model){
            if(arg.equals("loggedIn"))
                massage.set("hello " + model.currentUser.getName());
            setChanged();
            notifyObservers(arg);
        }
    }
}
