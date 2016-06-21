package com.github.umkamax.taxisto.application.controller;

import com.github.umkamax.taxisto.application.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("user")
public class UserController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal user) {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return user;
    }
}
