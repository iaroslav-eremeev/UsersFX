package com.iaroslaveremeev.usersfx;

import javafx.scene.control.Alert;

public class SecondController {
    private String data;

    public void initData(String data){
        this.data = data;
        App.showAlertWithoutHeaderText("Info", this.data.toString(), Alert.AlertType.INFORMATION);
    }
}
