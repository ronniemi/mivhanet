package View;

import ViewModel.MyViewModel;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class MyView implements Observer{
    MyViewModel viewModel;

    public void setViewModel(MyViewModel viewModel) {

        this.viewModel = viewModel;

    }

    @Override
    public void update(Observable o, Object arg) {

    }



    public void closeProgram()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        //alert.setHeaderText("Are you sure?");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
            Platform.exit();
        } else {
            alert.close();
        }
    }
}
