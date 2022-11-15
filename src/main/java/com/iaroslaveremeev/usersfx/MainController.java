package com.iaroslaveremeev.usersfx;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.iaroslaveremeev.usersfx.model.User;
import com.iaroslaveremeev.usersfx.Repository.UsersRepo;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    @FXML
    public void buttonNewForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "second.fxml"
                )
        );
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load(), 500, 500)
        );
        SecondController controller = loader.getController();
        controller.initData("dfghjk");
        stage.show();
        Stage close = (Stage) this.buttonUserChosen.getScene().getWindow();
        // do what you have to do
        close.close();
    }


}