package com.github.umkamax.taxisto.application.service;

import com.github.umkamax.taxisto.application.model.User;

public interface UserService {
    User findByName(String username);
}
