package com.iub.oop.spring25section1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Goal2Controller extends BaseController
{
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private CheckBox appendCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void writeToFile(ActionEvent actionEvent){
//        FileWriter fileWriter = null;
        try (FileWriter fileWriter = new FileWriter("data.txt")){
            fileWriter.write(textArea.getText());
            label.setText("Saved to 'data.txt'");
        } catch(IOException e){
            label.setText("Could not write to file!");
        }
    }
}