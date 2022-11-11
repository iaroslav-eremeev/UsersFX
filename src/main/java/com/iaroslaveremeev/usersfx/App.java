package com.iaroslaveremeev.usersfx;

import com.iaroslaveremeev.usersfx.Repository.UsersRepo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        UsersRepo usersRepo = new UsersRepo("https://jsonplaceholder.typicode.com/users");
        System.out.println(usersRepo.getUsers());
        /*launch();*/
    }
}