package com.iaroslaveremeev.usersfx.model;

import java.util.ArrayList;
import java.util.Objects;

public class UsersRepo {

    private ArrayList<User> users;

    public UsersRepo(String linkName) {

    }

    public ArrayList<User> getUsers() {
        return users;
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

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
