package com.hb.mapping.manytomany;

import com.hb.mapping.BuildSessionFactory;
import org.hibernate.Session;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManyToManyTest {

    public static void main(String...args){

        ManyToManyTest manyToManyTest = new ManyToManyTest();
        manyToManyTest.save(BuildSessionFactory.getSessionFactory().openSession());
        manyToManyTest.get(BuildSessionFactory.getSessionFactory().openSession());

    }



    public void save(Session session) {
        String[] employeeData = { "Peter Oven", "Allan Norman" };
        String[] projectData = { "IT Project", "Networking Project" };
        Set<Project> projects = new HashSet<Project>();

        for (String proj : projectData) {
            projects.add(new Project(proj));
        }

        for (String emp : employeeData) {
            Employee employee = new Employee(emp.split(" ")[0],
                    emp.split(" ")[1]);

            employee.setProjects(projects);
            session.persist(employee);
        }
    }

    public void get(Session session) {
        List<Employee> employeeList = session.createQuery("FROM Employee")
                .list();

        for(Employee employee : employeeList) {
            System.out.println(employee.getProjects());
        }
    }
}
