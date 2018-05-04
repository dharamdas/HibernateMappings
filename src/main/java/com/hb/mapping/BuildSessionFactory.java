package com.hb.mapping;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BuildSessionFactory {


    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.hb.mapping.hbmxmlconfigexample.Employee.class);
        configuration.addAnnotatedClass(com.hb.mapping.onetomany.Product.class);
        configuration.addAnnotatedClass(com.hb.mapping.onetomany.Category.class);
        configuration.addAnnotatedClass(com.hb.mapping.onetomany.Cart.class);
        configuration.addAnnotatedClass(com.hb.mapping.onetomany.Items.class);
        configuration.addAnnotatedClass(com.hb.mapping.manytomany1.Employee.class);
        configuration.addAnnotatedClass(com.hb.mapping.manytomany1.Meeting.class);

        configuration.addAnnotatedClass(com.hb.mapping.manytomany1.UserDetails.class);
        configuration.addAnnotatedClass(com.hb.mapping.manytomany1.Vehicle.class);

        //configuration.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
        configuration.configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }
}
