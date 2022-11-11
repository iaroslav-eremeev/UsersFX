package com.iaroslaveremeev.usersfx.model;

import java.util.Objects;

public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private com.iaroslaveremeev.usersfx.model.Address address;

    /**
     * "id": 1,
     *     "name": "Leanne Graham",
     *     "username": "Bret",
     *     "email": "Sincere@april.biz",
     *     "address": {
     *       "street": "Kulas Light",
     *       "suite": "Apt. 556",
     *       "city": "Gwenborough",
     *       "zipcode": "92998-3874",
     *       "geo": {
     *         "lat": "-37.3159",
     *         "lng": "81.1496"
     *       }
     *     },
     *     "phone": "1-770-736-8031 x56442",
     *     "website": "hildegard.org",
     *     "company": {
     *       "name": "Romaguera-Crona",
     *       "catchPhrase": "Multi-layered client-server neural-net",
     *       "bs": "harness real-time e-markets"
     *     }
     *   },
     */
    private String name;
    private String age;

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
