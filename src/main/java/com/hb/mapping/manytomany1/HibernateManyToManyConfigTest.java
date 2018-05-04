package com.hb.mapping.manytomany1;

import com.hb.mapping.BuildSessionFactory;
import org.hibernate.Session;

public class HibernateManyToManyConfigTest {
    public static void main(String...agrs)
    {
        Session session = BuildSessionFactory.getSessionFactory().openSession();


        Meeting meeting1 = new Meeting("Quaterly Sales meeting");
       // Meeting meeting2 = new Meeting("Weekly Status meeting");

        Employee employee1 = new Employee("Sergey", "Brin");
        Employee employee2 = new Employee("Larry", "Page");

        employee1.getMeetings().add(meeting1);
    //    employee1.getMeetings().add(meeting2);
        employee2.getMeetings().add(meeting1);

        meeting1.getEmployees().add(employee1);
        meeting1.getEmployees().add(employee2);

        //meeting2.getEmployees().add(employee1);
        //meeting2.getEmployees().add(employee2);

        session.beginTransaction();

        session.save(employee1);
        session.save(employee2);

        session.save(meeting1);
       // session.save(meeting2);




        session.getTransaction().commit();
        session.close();
    }




}
