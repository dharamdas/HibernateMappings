package com.hb.mapping.hbtemplateexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TemplateTest {

    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.hb.mapping.hbtemplateexample");//This will load the configured components UserService, UserRepository,
        ctx.refresh();

        System.out.println("Application Context Object: "+ctx);
        UserService userService = ctx.getBean(UserService.class);


        UserData user = new UserData(null, "K.siva reddy", "hyderabad");
        userService.createUser(user);
        //System.out.println("Newly created User Id="+id);

        List<UserData> allUser = userService.getAllUsers();

        for (UserData u : allUser)
        {
            System.out.println(u);
        }




    }
}
