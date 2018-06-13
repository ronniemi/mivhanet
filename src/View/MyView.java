package View;

import ViewModel.MyViewModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class MyView implements Observer{
    MyViewModel viewModel;

    @Override
    public void update(Observable o, Object arg) {

    }
}
