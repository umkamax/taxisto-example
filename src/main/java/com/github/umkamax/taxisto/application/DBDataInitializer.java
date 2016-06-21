package com.github.umkamax.taxisto.application;


import com.github.umkamax.taxisto.application.model.Post;
import com.github.umkamax.taxisto.application.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.Date;

@Component
public class DBDataInitializer {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void init() throws Exception {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User("admin", "admin");
        session.persist(user);

        session.persist(new Post("title1", "text", new Date(), user));
        session.persist(new Post("title2", "text", new Date(), user));
        session.persist(new Post("title3", "text", new Date(), user));
        session.persist(new Post("title4", "text", new Date(), user));
        session.persist(new Post("title5", "text", new Date(), user));
        session.persist(new Post("title6", "text", new Date(), user));
        session.persist(new Post("title7", "text", new Date(), user));
        session.persist(new Post("title8", "text", new Date(), user));
        session.persist(new Post("title9", "text", new Date(), user));
        session.persist(new Post("title10", "text", new Date(), user));
        session.persist(new Post("title11", "text", new Date(), user));

        transaction.commit();

//        System.out.println(session.createQuery(" from " + Post.class.getName()).list());
    }
}
