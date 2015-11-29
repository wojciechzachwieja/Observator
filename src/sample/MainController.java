package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sample.Model.CollectionStudent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Wojciech on 2015-11-27.
 */
public class MainController implements Initializable {
    public AnchorPane dialog;
    public AnchorPane dialog2;

    @FXML private Controller dialogController;

    @FXML private Controller2 dialogController2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Main");

    }
}
