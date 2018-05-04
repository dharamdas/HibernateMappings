package com.hb.mapping.hbtemplateexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public class UserRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<UserData> getAllUsers()
    {
        return this.hibernateTemplate.loadAll(UserData.class);
    }

    public void createUser(UserData user)
    {
        System.out.println("Executing CreateUser() of UserRepository--------");

      this.hibernateTemplate.save(user);
    }
}
