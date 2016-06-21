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
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long count() {
        return postService.count();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Post> findPosts(@RequestParam("offset") Integer offset, @RequestParam("maxResults") Integer maxResults) {
        return postService.findPosts(offset, maxResults);
    }

    @ResponseBody
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    public Post findPost(@PathVariable("postId") Long postId) {
        return postService.findPostById(postId);
    }

//    @Secured("ROLE_ADMIN")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

}
