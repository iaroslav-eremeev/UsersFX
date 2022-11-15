package com.iaroslaveremeev.usersfx.Repository;

import com.iaroslaveremeev.usersfx.model.Employee;
import com.iaroslaveremeev.usersfx.model.User;

import java.util.ArrayList;
import java.util.Objects;

public class EmployeesRepo {
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeesRepo() {
    }

    public EmployeesRepo(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesRepo that = (EmployeesRepo) o;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }

    @Override
    public String toString() {
        return "EmployeesRepo{" +
                "employees=" + employees +
                '}';
    }
}
