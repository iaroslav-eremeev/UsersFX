package com.iaroslaveremeev.usersfx;

import com.iaroslaveremeev.usersfx.Repository.EmployeesRepo;
import com.iaroslaveremeev.usersfx.Repository.UsersRepo;
import com.iaroslaveremeev.usersfx.model.Employee;
import com.iaroslaveremeev.usersfx.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SecondController {
    @FXML
    public ComboBox<Employee> employeesRepoComboBox;
    public Button buttonEmployeeChosen;
    public ListView chosenDevsList;
    public ListView chosenTestersList;
    public ListView chosenDesignersList;
    public ListView chosenManagersList;

    public HashMap<String, ArrayList<Employee>> employeesHashMap = new HashMap<>();

    @FXML
    public void initialize() throws IOException {
        EmployeesRepo employeesRepo = new EmployeesRepo("employees.json");
        this.employeesRepoComboBox.setItems(FXCollections.observableList(employeesRepo.getEmployees()));
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

    public void onButtonEmployeeChosenClick(ActionEvent actionEvent) {
        Employee selectedEmployee = this.employeesRepoComboBox.getSelectionModel().getSelectedItem();
        this.employeesHashMap.getOrDefault(selectedEmployee.getJob(), new ArrayList<>());
        this.employeesHashMap.computeIfAbsent(selectedEmployee.getJob(), k -> new ArrayList<>())
                .add(selectedEmployee);
        this.chosenDevsList.getItems().setAll(this.employeesHashMap.get("developer"));
        this.chosenManagersList.getItems().setAll(this.employeesHashMap.get("project_manager"));
        this.chosenDesignersList.getItems().setAll(this.employeesHashMap.get("designer"));
        this.chosenTestersList.getItems().setAll(this.employeesHashMap.get("tester"));
    }
}
