package View;

import Model.Course;
import Model.Question;
import ViewModel.MyViewModel;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.*;

/**
 * Created by ronnie on 13-Jun-18.
 */
public class MyView implements Observer{
    MyViewModel viewModel;
    public Label massage;

    private Stage lastStage;

    public void init(Stage stage)
    {
        lastStage=stage;
    }



    public void setViewModel(MyViewModel viewModel) {
        this.viewModel = viewModel;
      //  massage.textProperty().bind(viewModel.massage);
    }



    public void getAllCourse(){
        HashSet<Course> courses = viewModel.getAllCourses();
    }

    public void getAllQuestionInCourse(String courseId){
        HashSet<Question> questions = viewModel.getAllQuestionsInCourse(courseId);
        Iterator<Question> iter = questions.iterator();
        System.out.println(questions.size());
        while(iter.hasNext())
        {
            Question q = iter.next();
            System.out.println(q.body);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    private void showAlert(String alertMessage, String title) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(alertMessage);
        alert.showAndWait();
    }

    public void changePass()
    {
        try
        {
            Stage stage = new Stage();

            stage.setTitle("Mivhanet");
            //stage.getIcons().add(new Image("resources//8.png".toString()));
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("ChangePass.fxml").openStream());
            Scene scene = new Scene(root, 800, 700);
            scene.getStylesheets().add(getClass().getResource("ViewStyle.css").toExternalForm());
            stage.setScene(scene);
            //Image image = new Image("resources//Images//source.GIF");  //pass in the image path
            //scene.setCursor(new ImageCursor(image));

            ChangePassController passCont = fxmlLoader.getController();
            passCont.init(stage);

            passCont.setViewModel(viewModel);

            viewModel.addObserver(passCont);


            stage.setOnCloseRequest(event -> {
                viewModel.exit();
                event.consume();
                System.exit(0);
                Platform.exit();
            });

            lastStage.close();

            stage.show();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }

    public void delQuest(){

        try
        {
            Stage stage = new Stage();

            stage.setTitle("Mivhanet");
            //stage.getIcons().add(new Image("resources//8.png".toString()));
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("DeleteQuest.fxml").openStream());
            Scene scene = new Scene(root, 800, 700);
            scene.getStylesheets().add(getClass().getResource("ViewStyle.css").toExternalForm());
            stage.setScene(scene);
            //Image image = new Image("resources//Images//source.GIF");  //pass in the image path
            //scene.setCursor(new ImageCursor(image));

            DeleteQuetController delQuest= fxmlLoader.getController();
            delQuest.setViewModel(viewModel);
            delQuest.init(stage);



            viewModel.addObserver(delQuest);


            stage.setOnCloseRequest(event -> {
                viewModel.exit();
                event.consume();
                System.exit(0);
                Platform.exit();
            });

            lastStage.close();

            stage.show();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

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
