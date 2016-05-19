package com.github.umkamax.taxisto.application.dao.impl;

import com.github.umkamax.taxisto.application.dao.PostDAO;
import com.github.umkamax.taxisto.application.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Post save(Post post) {
        return em.merge(post);
    }

    @Override
    public void delete(Long postId) {
        Post post = em.find(Post.class, postId);
        em.remove(post);
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery(" from " + Post.class.getName()).getResultList();
    }
}
