package com.Kishore.Form.Repository;

import com.Kishore.Form.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails,Integer> {
    @Query("SELECT u FROM UserDetails u  where u.username=:username")
    public Optional<UserDetails> findByUsername(@Param("username") String username);
}

