package com.github.umkamax.taxisto.application.service.impl;

import com.github.umkamax.taxisto.application.dao.UserDAO;
import com.github.umkamax.taxisto.application.model.User;
import com.github.umkamax.taxisto.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public User findByName(String username) {
        return userDAO.findByName(username);
    }
}
