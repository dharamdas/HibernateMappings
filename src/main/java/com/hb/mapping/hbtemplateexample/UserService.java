package com.hb.mapping.hbtemplateexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserData> getAllUsers()
    {
        return this.userRepository.getAllUsers();
    }

    public void createUser(UserData user)
    {
        System.out.println("Executing CreateUser() --------");
        this.userRepository.createUser(user);
    }
}
