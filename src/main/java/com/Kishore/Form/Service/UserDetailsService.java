package com.Kishore.Form.Service;

import com.Kishore.Form.Entity.UserDetails;

import java.util.List;

public interface UserDetailsService {
    public List<UserDetails> getAllUsers();
    public UserDetails saveUser(UserDetails userDetails);
    public void updateUser(UserDetails userDetails);
    public void deleteUser(int id);
    public  UserDetails findUser(int id);

}
