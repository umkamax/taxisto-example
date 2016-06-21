package com.github.umkamax.taxisto.application.dao.impl;

import com.github.umkamax.taxisto.application.dao.PostDAO;
import com.github.umkamax.taxisto.application.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {

    private static final int POSTS_BY_PAGE = 5;

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
    public Long count() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Post> root = cq.from(Post.class);
        cq.select(cb.count(root));
        return em.createQuery(cq).getSingleResult();
    }

    @Override
    public List<Post> findAll(Integer offset, Integer maxResults) {
        return em.createQuery(" from Post order by date desc")
                .setFirstResult(offset != null ? offset : 0)
                .setMaxResults(maxResults != null ? maxResults : POSTS_BY_PAGE)
                .getResultList();
    }

    @Override
    public Post findById(Long postId) {
        return em.find(Post.class, postId);
    }
}
