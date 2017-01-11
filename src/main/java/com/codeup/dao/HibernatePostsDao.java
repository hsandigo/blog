package com.codeup.dao;

import com.codeup.models.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernatePostsDao implements Posts {
    private Session session;

    HibernatePostsDao(Session session) {this.session = session;}

    @Override
    public List<Post> getAllPosts() {

        return session.createQuery("from Post").list();
    }

    @Override
    public void savePost(Post post) {
        Transaction tx = session.beginTransaction();
        session.save(post);
        tx.commit();
    }

    @Override
    public Post getPostById(int id) {
        Query query = session.createQuery("from Post where id = :id");
        query.setParameter("id", id);
        return (Post) query.getSingleResult();
    }

    @Override
    public void updatePost(Post post) {
        Transaction tx = session.beginTransaction();
        session.update(post);
        tx.commit();
    }

    @Override
    public void deletePost(Post post) {
        Transaction tx = session.beginTransaction();
        session.delete(post);
        tx.commit();
    }


}
