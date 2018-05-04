package com.hb.mapping.connectdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
