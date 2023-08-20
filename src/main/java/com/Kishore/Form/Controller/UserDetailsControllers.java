package com.Kishore.Form.Controller;

import com.Kishore.Form.Entity.UserDetails;
import com.Kishore.Form.Exception.UserNotFound;
import com.Kishore.Form.Repository.UserRepository;
import com.Kishore.Form.Service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/users")
public class UserDetailsControllers {

        @Autowired
        UserDetailsService service;
        @Autowired
        UserRepository repo;

        @GetMapping("/allUsers")
        public ResponseEntity<?> getAllUsers() throws UserNotFound {
            if (repo.findAll().isEmpty()) {
                throw new UserNotFound("User is not found");
            } else {

                return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
            }
        }

        @PostMapping("/addUser")
        public ResponseEntity<?> saveUser(@RequestBody UserDetails user) throws UserNotFound {
            Optional<UserDetails> opt = repo.findByUsername(user.getUsername());
            if (opt.isPresent()) {
                throw new UserNotFound("User is already existed");
            } else {
                service.saveUser(user);
                return new ResponseEntity<>("user is created", HttpStatus.CREATED);
            }

        }

        @PutMapping("/updateUser/{id}")
        public ResponseEntity<?> UpdateUser(@RequestBody UserDetails user) throws UserNotFound {
            if (repo.existsById(user.getId())) {
                service.updateUser(user);
                return new ResponseEntity<>("id" + user.getId() + "is updated successfully", HttpStatus.ACCEPTED);
            } else {

                throw new UserNotFound("id" + user.getId() + "is not updated");
            }
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteUser(@PathVariable("id") int id) throws UserNotFound {
            Optional<UserDetails> opt = repo.findById(id);
            if (opt.isPresent()) {
                service.deleteUser(id);
                return new ResponseEntity<>("id" + "deleted successfully", HttpStatus.OK);
            } else {
                throw new UserNotFound("id" + "is not found");
            }
        }

    }

