package com.iub.oop.spring25section1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {
    @FXML
    private Label messageLabel;
    @FXML
    private TextField filterAge;
    @FXML
    private TableColumn<User, String> usernameCol;
    @FXML
    private TableColumn<User, Integer> ageCol;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> passwordCol;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private ComboBox<Integer> ageCB;
    @FXML
    private Label summaryLabel;

    public void initialize() {
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        for (int i = 18; i <= 80; i++)
            ageCB.getItems().add(i);

        tableView.getItems().addAll(UserManager.userList);

        if (EditUserController.action == 0) {
            messageLabel.setText("User updated successfully!");
        } else if (EditUserController.action == 1) {
            messageLabel.setText("User update cancelled!");
        }

    }

    @FXML
    public void filter(ActionEvent actionEvent) {
        try {
            messageLabel.setText("");
            int maxAge = Integer.parseInt(filterAge.getText());

            tableView.getItems().clear();
            for (User u : UserManager.userList) {
                if (u.getAge() < maxAge) tableView.getItems().add(u);
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid input for filter!");
        }
    }

    @FXML
    public void addUser(ActionEvent actionEvent) {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        int age = ageCB.getValue();

        if (username.isBlank() || password.isBlank()) {
            messageLabel.setText("Username and Password cannot be empty!");
            return;
        }

        for (User u : UserManager.userList) {
            if (u.getUsername().equals(username)) {
                messageLabel.setText("Username is not unique");
                return;
            }
        }

        User u = new User(username, password, age);
        UserManager.userList.add(u);
        tableView.getItems().add(u);
    }

    @FXML
    public void resetFilter(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(UserManager.userList);
    }

    @FXML
    public void summary(ActionEvent actionEvent) {
        // maximum age
//        int maxAge = userList.getFirst().getAge();
//        for (User u: userList) {
//            if (u.getAge() > maxAge) {
//                maxAge = u.getAge();
//            }
//        }
//        summaryLabel.setText("Maximum age is " + maxAge);

        // minimum age
//        int minAge = userList.getFirst().getAge();
//        for (User u: userList) {
//            if (u.getAge() < minAge) {
//                minAge = u.getAge();
//            }
//        }
//        summaryLabel.setText("Minimum age is " + minAge);

        // average age
//        int sumAge = 0;
//        for (User u: userList) {
//            sumAge += u.getAge();
//        }
//        summaryLabel.setText("Average age is " + (double) sumAge / userList.size());

        // average password length
        int sumLength = 0;
        for (User u : UserManager.userList) {
            sumLength += u.getPassword().length();
        }
        summaryLabel.setText("Average password length is " + (double) sumLength / UserManager.userList.size());

    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("login");
    }

    @FXML
    public void editUser(ActionEvent actionEvent) throws IOException {
//        int index = tableView.getSelectionModel().getSelectedIndex();
        User u = tableView.getSelectionModel().getSelectedItem();
        if (u == null) return;
//        userToEdit = u;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-user.fxml"));
        Parent root = loader.load();

        EditUserController controller = loader.getController();
        controller.setUser(u);

        Scene scene = new Scene(root);
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(scene);


//        SceneSwitcher.switchTo("edit-user");
    }

    @FXML
    public void saveToFile(ActionEvent actionEvent) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            for (User u: tableView.getItems()) {
                outputStream.writeObject(u);
            }
            messageLabel.setText("Data saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Could not save data to file.");
        }
    }

    @FXML
    public void loadFromFile(ActionEvent actionEvent) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.bin"));) {
            while (true) {
                User u = (User) inputStream.readObject();
                tableView.getItems().add(u);
            }
        } catch (EOFException e) {
            messageLabel.setText("Data loaded from file");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            messageLabel.setText("Invalid file format!");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Could not load data from file");
        }
    }
}