package com.github.umkamax.taxisto.application.dao;

import com.github.umkamax.taxisto.application.model.User;

public interface UserDAO {
    User findByName(String username);
}
