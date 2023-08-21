package com.Kishore.Form.Repository;

import com.Kishore.Form.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Employee,Integer> {
    @Query("SELECT e FROM Employee e  where e.username=:username")
    public Optional<Employee> findByUsername(@Param("username") String username);
}

