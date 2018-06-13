package ViewModel;

import Model.MySystemModel;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class MyViewModel extends Observable implements Observer {
    private MySystemModel model;

    public void MyViewModel(MySystemModel model){

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
