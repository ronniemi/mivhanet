package ViewModel;

import Model.SystemModel;
import javafx.util.Pair;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class MyViewModel extends Observable implements Observer {
    private SystemModel model;

    public void MyViewModel(SystemModel model){
        model.addObserver(this);
        this.model = model;
    }

    public void login(String username, String password){
        model.login(username,password);
    }

    public Pair<String,String> register(String ID, String name, String address, String phoneNumber, String email, String role){
        Pair<String,String> usernameAndPassword = model.createNewUser(ID, name, address, phoneNumber, email, role);
        return usernameAndPassword;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o == model){
            if(arg.equals("loggedIn")){
            }
            notifyObservers(arg);
        }
    }
}
