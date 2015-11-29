package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        primaryStage.setTitle("Options");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("view2.fxml"));
        Stage stage = new Stage();
        Parent root2 = fxmlLoader2.load();
        stage.setTitle("Charts");
        stage.setScene(new Scene(root2));
        stage.show();
        Controller2 controller2 = fxmlLoader2.getController();
        controller.controller2 = controller2;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
