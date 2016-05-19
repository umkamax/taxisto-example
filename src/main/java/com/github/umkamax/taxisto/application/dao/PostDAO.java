package com.github.umkamax.taxisto.application.dao;

import com.github.umkamax.taxisto.application.model.Post;

import java.util.List;

public interface PostDAO {

    Post save(Post post);
    void delete(Long postId);
    List<Post> findAll();

}
