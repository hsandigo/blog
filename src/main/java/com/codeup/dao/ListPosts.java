package com.codeup.dao;

import com.codeup.models.Post;

import java.util.ArrayList;
import java.util.List;


public abstract class ListPosts implements Posts {
    private List<Post> allPosts;

    public ListPosts(){
        allPosts = new ArrayList<>();
    }
    @Override
    public List<Post> getAllPosts() {
        return allPosts;
    }

    @Override
    public void savePost(Post post) {
        post.setId(allPosts.size()+ 1);
        allPosts.add(post);
    }
}
