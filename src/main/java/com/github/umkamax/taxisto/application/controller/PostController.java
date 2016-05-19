package com.github.umkamax.taxisto.application.controller;

import com.github.umkamax.taxisto.application.model.Post;
import com.github.umkamax.taxisto.application.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostService postService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Post> findPosts() {
        return postService.findPosts();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Post savePost(@RequestParam Post post) {
        return postService.savePost(post);
    }

}
