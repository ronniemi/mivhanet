package View;
import Model.MySystemModel;
import ViewModel.MyViewModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try{
            MySystemModel model = new MySystemModel();
            MyViewModel viewModel = new MyViewModel(model);
            model.addObserver(viewModel);
            stage.setTitle("Mivhanet");
            //stage.getIcons().add(new Image("resources//8.png".toString()));
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("Login.fxml").openStream());

            Scene scene = new Scene(root, 800, 700);
            scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
            stage.setScene(scene);
            /*
            Image image = new Image("resources//Images//source.GIF");  //pass in the image path
            scene.setCursor(new ImageCursor(image));

            */

            LoginController login = fxmlLoader.getController();
            //view.setResizeEvent(scene);
            login.setViewModel(viewModel);
            viewModel.addObserver(login);

            login.init(stage);

            stage.setOnCloseRequest(event -> {
                viewModel.exit();
                event.consume();
                System.exit(0);
                Platform.exit();
            });


            // firststage.close();
            stage.show();
        }


        catch(Exception e)
        {
            System.out.println(e);
        }





    }


    public static void main(String[] args) {
        launch(args);
    }
}
