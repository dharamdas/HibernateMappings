package com.hb.mapping.connectdb;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp  implements UserDao{


    @Autowired
    private SessionFactory sessionFactory;

    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> listUsers() {

        Query query=  sessionFactory.getCurrentSession().createQuery("from User");
        return query.list();
    }

}
