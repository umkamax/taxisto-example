package com.github.umkamax.taxisto.application.service.impl;

import com.github.umkamax.taxisto.application.dao.PostDAO;
import com.github.umkamax.taxisto.application.model.Post;
import com.github.umkamax.taxisto.application.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDAO postDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Post> findPosts() {
        return postDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Post findPostById(Long postId) {
        return null;
    }

    @Override
    @Transactional
    public Post savePost(Post post) {
        return null;
    }

    @Override
    @Transactional
    public void deletePost(Long Id) {

    }
}
