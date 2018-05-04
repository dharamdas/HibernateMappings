package com.hb.mapping.onetomany;

import com.hb.mapping.BuildSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StockManager {


    public static void main(String...args)
    {


        StockManager stockManager = new StockManager();

        stockManager.execute();


    }


    public void execute()
    {

        Session session = BuildSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Category category = new Category("Computer");

        Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);

        Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, category);

        Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499, category);

        Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);

        Set<Product> products = new HashSet<Product>();
        products.add(pc);
        products.add(laptop);
        products.add(phone);
        products.add(tablet);

        category.setProducts(products);

        session.save(category);

        session.getTransaction().commit();
        session.close();
    }
}
