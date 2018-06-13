package ViewModel;

import Model.SystemModel;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class MyViewModel extends Observable implements Observer {
    private SystemModel model;

    public MyViewModel(SystemModel model){

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
