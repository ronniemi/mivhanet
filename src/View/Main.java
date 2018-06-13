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


public class Main {
/*

    @Override
    public void start(Stage stage) throws Exception {
        try{
            MySystemModel model = new MySystemModel();
            MyViewModel viewModel = new MyViewModel(model);
            model.addObserver(viewModel);
            stage.setTitle("Mivhanet");
            //stage.getIcons().add(new Image("resources//Images//8.png".toString()));

            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("MyView.fxml").openStream());

            Scene scene = new Scene(root, 800, 700);
            scene.getStylesheets().add(getClass().getResource("ViewStyle.css").toExternalForm());
            stage.setScene(scene);*/
            /*
            Image image = new Image("resources//Images//source.GIF");  //pass in the image path
            scene.setCursor(new ImageCursor(image));

            */
/*
            MyView view = fxmlLoader.getController();
            //view.setResizeEvent(scene);
            view.setViewModel(viewModel);
            viewModel.addObserver(view);


            stage.setOnCloseRequest(event -> {
                event.consume();
                view.closeProgram();
            });
            // firststage.close();
            stage.show();
        }


        catch(Exception e)
        {
            System.out.println(e);
        }
    }
*/
    public static void main(String[] args) {
        MySystemModel model = new MySystemModel();
        MyViewModel viewModel = new MyViewModel(model);
        model.addObserver(viewModel);
        MyView view = new MyView();
        view.setViewModel(viewModel);
        viewModel.addObserver(view);

        //view.login();
        view.changePassword("u1","123456","abcdef");
    }
}
