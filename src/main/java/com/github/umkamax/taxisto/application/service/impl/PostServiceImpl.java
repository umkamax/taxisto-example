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
    public Long count() {
        return postDAO.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findPosts(Integer offset, Integer maxResults) {
        return postDAO.findAll(offset, maxResults);
    }

    @Override
    @Transactional(readOnly = true)
    public Post findPostById(Long postId) {
        return null;
    }

    @Override
    @Transactional
    public Post savePost(Post post) {
        Long count = postDAO.count();
        System.out.println(count);
        return postDAO.save(post);
    }

    @Override
    @Transactional
    public void deletePost(Long Id) {

    }
}
