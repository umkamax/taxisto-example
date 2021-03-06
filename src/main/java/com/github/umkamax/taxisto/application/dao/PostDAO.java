package com.github.umkamax.taxisto.application.dao;

import com.github.umkamax.taxisto.application.model.Post;

import java.util.List;

public interface PostDAO {

    Post save(Post post);
    void delete(Long postId);
    Long count();
    List<Post> findAll(Integer offset, Integer maxResults);
    Post findById(Long postId);

}
