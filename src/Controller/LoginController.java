package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.LoginModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {
    public LoginModel loginModel = new LoginModel();


    @FXML
    private TextField username_lbl;

    @FXML
    private PasswordField password_lbl;

    @FXML
    private Label errorlabel;

    @FXML
    void signUpBtn(ActionEvent actionEvent) {

        ((Node)actionEvent.getSource()).getScene().getWindow().hide();

        Stage primaryStage = new Stage();

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../views/signup.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Fruits Market");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void logBtn (ActionEvent actionEvent) {
        try {
            if (loginModel.isLogin(username_lbl.getText() , password_lbl.getText())) {
                ((Node)actionEvent.getSource()).getScene().getWindow().hide();

                Stage primaryStage = new Stage();
                primaryStage.setFullScreen(true);

                Parent root = null;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../views/market.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.setTitle("Fruits Market");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();

            } else {
                errorlabel.setText("Invalid username or password");
            }
        } catch (SQLException e) {
            errorlabel.setText("Invalid username or password");
            e.printStackTrace();
        }
    }

}
