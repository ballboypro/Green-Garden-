package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DeliveryController {
    @FXML
    private Label MainLabel;

    @FXML
    private Label textLabel;

    public void OkBtn (ActionEvent actionEvent) {
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
    }
}
