package com.github.umkamax.taxisto.application;


import com.github.umkamax.taxisto.application.model.Post;
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

        session.persist(new Post ("title", "text", new Date()));

        transaction.commit();

        System.out.println(session.createQuery(" from " + Post.class.getName()).list());
    }
}
