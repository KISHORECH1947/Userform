package com.Kishore.Form.ServiceImpl;

import com.Kishore.Form.Entity.Employee;
import com.Kishore.Form.Repository.UserRepository;
import com.Kishore.Form.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class EmployeeServiceImpl implements EmployeeService {

        @Autowired
        UserRepository repo;
        @Override
        public List<Employee> getAllUsers() {
            return repo.findAll();
        }

        @Override
        public Employee saveUser(Employee employee) {
            return repo.save(employee);
        }

        @Override
        public void updateUser(Employee employee) {
            repo.save(employee);
        }

        @Override
        public void deleteUser(int id) {
            repo.deleteById(id);

        }

        @Override
        public Employee findUser(int id) {
            return repo.findById(id).get();
        }
    }



