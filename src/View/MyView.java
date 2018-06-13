package View;

import ViewModel.MyViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class MyView implements Observer{
    MyViewModel viewModel;

    //public Label massage;

    public void setViewModel(MyViewModel viewModel) {
        this.viewModel = viewModel;
        //massage.textProperty().bind(viewModel.massage);
    }

    public void login(){
        viewModel.login("u1", "123456");
    }

    public void changePassword(String username, String oldPassword, String newPassword){
        viewModel.changePassword(username, oldPassword, newPassword);
    }

    public void deleteQuestion(String courseId, String questionId){
        viewModel.deleteQuestion(courseId, questionId);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o == viewModel){
           /* if(arg.equals("questionDeleted"))
                showAlert("Question deleted!", "MIVHANET");
            else if(arg.equals("questionNotDeleted"))
                showAlert("Question not deleted!", "MIVHANET");
            else if(arg.equals("loggedIn"))
                showAlert("you are now logged in!", "MIVHANET");
            else if(arg.equals("errorLoggedIn"))
                showAlert("wrong username or password", "MIVHANET");
            else if(arg.equals("passwordNotChanged"))
                showAlert("wrong username or password", "MIVHANET");
            else if(arg.equals("passwordChanged"))
                showAlert("password changed!", "MIVHANET");
            else if(arg.equals("illegalPassword"))
                showAlert("password need to be 6 characters long", "MIVHANET");*/
            System.out.println(arg);

        }
    }

    private void showAlert(String alertMessage, String title) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(alertMessage);
        alert.showAndWait();
    }


    public void closeProgram()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        //alert.setHeaderText("Are you sure?");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            viewModel.exit();
            System.exit(0);
            Platform.exit();
        } else {
            alert.close();
        }
    }
}
