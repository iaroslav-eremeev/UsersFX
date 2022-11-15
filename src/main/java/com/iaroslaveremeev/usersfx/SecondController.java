package com.iaroslaveremeev.usersfx;

import com.iaroslaveremeev.usersfx.Repository.UsersRepo;
import com.iaroslaveremeev.usersfx.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class SecondController {
    @FXML
    public ComboBox<User> employeesRepoComboBox;
    public Button buttonEmployeeChosen;
    public ListView chosenDevsList;
    public ListView chosenTestersList;
    public ListView chosenDesignersList;
    public ListView chosenManagersList;

    /*public void initData(String data){
        this.data = data;
        App.showAlertWithoutHeaderText("Info", this.data.toString(), Alert.AlertType.INFORMATION);
    }*/
}
