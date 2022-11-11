package com.iaroslaveremeev.usersfx.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.iaroslaveremeev.usersfx.model.User;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsersRepo {

    /**
     * При старте формы загружается репозиторий с юзерами по ссылке и отображается в comboBox
     *
     * При выборе юзера он должен быть отображен в консоли
     */
    private ArrayList<User> users = new ArrayList<>();

    public UsersRepo() {
    }

    public UsersRepo(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        ObjectMapper objectMapper = new ObjectMapper();
        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(httpURLConnection.getInputStream())) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            this.users = objectMapper.readValue(bytes, new TypeReference<>() {});
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersRepo usersRepo = (UsersRepo) o;
        return Objects.equals(users, usersRepo.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "UsersRepo{" +
                "users=" + users +
                '}';
    }
}
