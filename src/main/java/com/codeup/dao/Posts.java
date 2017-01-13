package com.codeup.dao;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



/**
 * Created by hsandigo on 1/5/17.
 */
public interface Posts {
    List<Post> findAll();
    Post findById(int id);

    void save(Post post);

    void delete(Post post);

//    List<Post> getAllPosts();
//    void savePost(Post post);
//    Post getPostById(int id);
//    void updatePost(Post post);
//    void deletePost(Post post);
}
