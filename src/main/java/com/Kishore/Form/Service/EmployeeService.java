package com.Kishore.Form.Service;

import com.Kishore.Form.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllUsers();
    public Employee saveUser(Employee userDetails);
    public void updateUser(Employee userDetails);
    public void deleteUser(int id);
    public Employee findUser(int id);

}
