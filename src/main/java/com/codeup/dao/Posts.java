package com.codeup.dao;

import com.codeup.models.Post;

import java.util.List;

/**
 * Created by humbertosandigo on 1/5/17.
 */
public interface Posts {

    List<Post> getAllPosts();

    void savePost(Post post);

    Post find(long id);

    void update(Post existingPost);
}

