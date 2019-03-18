package ca.ucalgary.gui;

import ca.ucalgary.gui.login.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;



public class BankApplicationController implements Initializable {

    @FXML
    private Button goTo;
    @FXML
    private Button changeSceneButton;
    @FXML
    private AnchorPane sceneChange;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void goToLogin(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Parent loginParent = (Parent)loader.load();
        LoginController controller = loader.<LoginController>getController();
        controller.setMessage("Hello");
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    private void changeScene(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene.fxml"));
        Parent loginParent = (Parent)loader.load();
        sceneChange.getChildren().setAll(loginParent);
    }

}
