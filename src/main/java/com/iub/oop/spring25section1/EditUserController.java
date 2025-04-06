package com.iub.oop.spring25section1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class EditUserController
{
    @javafx.fxml.FXML
    private TextField usernameTF;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private ComboBox<Integer> ageCB;

    public static int action = -1;

    private User user;

    public void setUser(User user) {
        System.out.println("user = " + user);
        this.user = user;

        usernameTF.setText(user.getUsername());
        passwordTF.setText(user.getPassword());
        ageCB.setValue(user.getAge());
    }

    @javafx.fxml.FXML
    public void initialize() {
        for (int i = 18; i <= 80; i++)
            ageCB.getItems().add(i);
    }

    @javafx.fxml.FXML
    public void cancel(ActionEvent actionEvent) throws IOException {
        action = 1;
        SceneSwitcher.switchTo("hello-view");
    }

    @javafx.fxml.FXML
    public void updateUser(ActionEvent actionEvent) throws IOException {
        user.setUsername(usernameTF.getText());
        user.setPassword(passwordTF.getText());
        user.setAge(ageCB.getValue());

        action = 0;

        SceneSwitcher.switchTo("hello-view");
    }
}