package com.iaroslaveremeev.usersfx;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iaroslaveremeev.usersfx.model.User;
import com.iaroslaveremeev.usersfx.Repository.UsersRepo;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainController {

    @FXML
    public ComboBox<User> usersRepoComboBox;
    public Button buttonUserChosen;
    public ListView chosenUsersList;

    public UsersRepo resRepo = new UsersRepo();
    @FXML
    public void initialize() throws IOException {
        UsersRepo usersRepo = new UsersRepo("https://jsonplaceholder.typicode.com/users");
        this.usersRepoComboBox.setItems(FXCollections.observableList(usersRepo.getUsers()));
    }

    @FXML
    protected void onButtonClick() {
        User selectedUser = this.usersRepoComboBox.getSelectionModel().getSelectedItem();
        this.chosenUsersList.getItems().add(selectedUser);
        this.resRepo.addUser(selectedUser);
        App.showAlertWithoutHeaderText("Info", selectedUser.showInfo(), Alert.AlertType.INFORMATION);
    }

    @FXML
    public void onJsonMakerButtonClick() {
        ObjectMapper objectMapper = new ObjectMapper();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.json"))){
            objectMapper.writeValue(bufferedWriter, this.chosenUsersList.getItems());
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void buttonFileOpen(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "TXT files", "*.txt", "*.TXT"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "CSV files", "*.csv", "*.CSV"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            System.out.println(file);
        }
    }
}