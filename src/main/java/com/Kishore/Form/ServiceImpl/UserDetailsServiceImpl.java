package com.Kishore.Form.ServiceImpl;

import com.Kishore.Form.Entity.UserDetails;
import com.Kishore.Form.Repository.UserRepository;
import com.Kishore.Form.Service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
     UserRepository repo;
    @Override
    public List<UserDetails> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserDetails saveUser(UserDetails userDetails) {
        return repo.save(userDetails);
    }

    @Override
    public void updateUser(UserDetails userDetails) {
                 repo.save(userDetails);
    }

    @Override
    public void deleteUser(int id) {
        repo.deleteById(id);

    }

    @Override
    public UserDetails findUser(int id) {
        return repo.findById(id).get();
    }
}
