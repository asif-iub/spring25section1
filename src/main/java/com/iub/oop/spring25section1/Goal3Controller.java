package com.iub.oop.spring25section1;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.FileReader;
import java.io.IOException;

public class Goal3Controller extends BaseController {
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextArea textArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadFromFile(ActionEvent actionEvent) {
        try (FileReader reader = new FileReader("data.txt");) {
            String content = "";
            while(true) {
                int i = reader.read();
                if (i == -1)
                    break;

                content = content + (char) i;
            }
            textArea.setText(content);
        }
        catch (IOException e) {
            label.setText("Could not load from file!");
        }
    }
}