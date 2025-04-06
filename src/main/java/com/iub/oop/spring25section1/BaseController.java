package com.iub.oop.spring25section1;

import javafx.event.ActionEvent;

import java.io.IOException;

public class BaseController {
    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("dashboard");
    }

    @javafx.fxml.FXML
    public void logOut(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("login");
    }
}
