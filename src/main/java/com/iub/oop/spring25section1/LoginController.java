package com.iub.oop.spring25section1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    @javafx.fxml.FXML
    private TextField usernameField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void login(ActionEvent actionEvent) throws IOException {
        for (User u: UserManager.userList) {
            if (usernameField.getText().equals(u.getUsername())
                    && passwordField.getText().equals(u.getPassword())) {
                messageLabel.setText("Log in successful!");
                // Now switch to the other scene
//                EditUserController.action = 1;
                SceneSwitcher.switchTo("dashboard");
//                Parent root = FXMLLoader.load(
//                        getClass().getResource("dashboard.fxml")
//                );
//                Scene scene = new Scene(root);
//                Stage stage = (Stage) messageLabel.getScene().getWindow();
////                Stage stage = new Stage();
//                stage.setScene(scene);
//                stage.show();
                return;
            }
        }
        messageLabel.setText("Invalid username or password!");
    }
}