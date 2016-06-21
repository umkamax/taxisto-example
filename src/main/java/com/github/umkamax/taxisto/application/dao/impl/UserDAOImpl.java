package com.github.umkamax.taxisto.application.dao.impl;

import com.github.umkamax.taxisto.application.dao.UserDAO;
import com.github.umkamax.taxisto.application.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findByName(String username) {
        List<User> users = em.createNamedQuery(User.FIND_BY_NAME, User.class)
                .setParameter("username", username)
                .getResultList();
        return users.size() == 1 ? users.get(0) : null;
    }
}
