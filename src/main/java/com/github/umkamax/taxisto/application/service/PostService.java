package com.github.umkamax.taxisto.application.service;

import com.github.umkamax.taxisto.application.model.Post;

import java.util.List;

public interface PostService {

    List<Post> findPosts();
    Post findPostById(Long postId);
    Post savePost(Post post);
    void deletePost(Long Id);

}
