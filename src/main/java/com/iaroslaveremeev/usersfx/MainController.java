package com.iaroslaveremeev.usersfx;

import com.iaroslaveremeev.usersfx.model.User;
import com.iaroslaveremeev.usersfx.model.UsersRepo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class MainController {

    @FXML
    public ComboBox<User> usersRepoComboBox;
    public Button buttonUserChosen;

    @FXML
    public void initialize(){
        UsersRepo usersRepo = new UsersRepo();

        usersRepoComboBox.setItems(FXCollections.observableList(usersRepo.getUsers()));
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onButtonClick() {
        User selectedUser = this.usersRepoComboBox.getSelectionModel().getSelectedItem();
        String userData = this.usersRepoComboBox;
    }
}