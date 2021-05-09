package Controller;

import helper.SQLiteConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class SignUpController {

    @FXML
    private TextField username_lbl;

    @FXML
    private TextField email_lbl;

    @FXML
    private PasswordField password_lbl;

    @FXML
    private Button signIn_btn;

    @FXML
    private Button login_btn;

    @FXML
    void signInBtn(ActionEvent actionEvent) {
        Connection connection = SQLiteConnector.Connector();

        try {

            String username = username_lbl.getText();
            String email = email_lbl.getText();
            String password = password_lbl.getText();

            Statement statement = connection.createStatement();

            if (!username.equals("") || !email.equals("") || !password.equals("")){
                int status = statement.executeUpdate("insert into user (username,email,password)" +
                        " values('" + username + "','" + email + "','" + password + "')");


                if (status > 0) {
                    System.out.println("user registered");
                }
            } else {
                System.out.println("empty");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ((Node)actionEvent.getSource()).getScene().getWindow().hide();

        Stage primaryStage = new Stage();

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../views/login.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Fruits Market");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void logBtn(ActionEvent actionEvent) {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();

        Stage primaryStage = new Stage();

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../views/login.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Fruits Market");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}