package com.iaroslaveremeev.usersfx.model;

import java.util.Objects;

public class Company {

    private String name;
    private String catchphrase;
    private String bs;

    public Company() {
    }

    public Company(String name, String catchphrase, String bs) {
        this.name = name;
        this.catchphrase = catchphrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchphrase() {
        return catchphrase;
    }

    public void setCatchphrase(String catchphrase) {
        this.catchphrase = catchphrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(catchphrase, company.catchphrase) && Objects.equals(bs, company.bs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catchphrase, bs);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", catchphrase='" + catchphrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
