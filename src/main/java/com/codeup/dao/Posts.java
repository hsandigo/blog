package com.codeup.dao;

import com.codeup.models.Post;

import java.util.List;

/**
 * Created by hsandigo on 1/5/17.
 */
public interface Posts {
    List<Post> getAllPosts();
    void savePost(Post post);
    Post getPostById(int id);
    void updatePost(Post post);
    void deletePost(Post post);
}
