package com.hb.mapping.hbtemplateexample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class RepositoryConfig {

    //${jdbc.driverClassName}
    @Value("${db.driver}")     private String driverClassName;
    @Value("${db.url}")                 private String url;
    @Value("${db.username}")             private String username;
    @Value("${db.password}")             private String password;

    @Value("${hibernate.dialect}")         private String hibernateDialect;
    @Value("${hibernate.show_sql}")     private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;

    @Bean()
    public DataSource getDataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }

    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        hibernateTemplate.setCheckWriteOperations(false);
        return hibernateTemplate;
    }

    @Bean
    @Autowired
    public Session getHibernateSession(HibernateTemplate hibernateTemplate){

    return hibernateTemplate.getSessionFactory().openSession();

    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory()
    {
        LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
        asfb.setDataSource(getDataSource());
        asfb.setHibernateProperties(getHibernateProperties());
        asfb.setPackagesToScan(new String[]{"com.hb.mapping.hbtemplateexample"});
        return asfb;
    }

    @Bean
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        System.out.println("hibernate.dialect: "+hibernateDialect);
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);

        return properties;
    }
}
