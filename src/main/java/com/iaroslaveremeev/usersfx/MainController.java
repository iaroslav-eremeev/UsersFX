package com.iaroslaveremeev.usersfx;

import com.iaroslaveremeev.usersfx.model.User;
import com.iaroslaveremeev.usersfx.Repository.UsersRepo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {

    @FXML
    public ComboBox<User> usersRepoComboBox;
    public Button buttonUserChosen;

    @FXML
    public void initialize() throws IOException {
        UsersRepo usersRepo = new UsersRepo("https://jsonplaceholder.typicode.com/users");
        this.usersRepoComboBox.setItems(FXCollections.observableList(usersRepo.getUsers()));
    }

    @FXML
    protected void onButtonClick() {
        User selectedUser = this.usersRepoComboBox.getSelectionModel().getSelectedItem();
        App.showAlertWithoutHeaderText("Info", selectedUser.showInfo(), Alert.AlertType.INFORMATION);
    }
}