package com.codeup.dao;

import com.codeup.models.Post;

import java.util.ArrayList;
import java.util.List;


public class ListPosts implements Posts{

    private List<Post> allPosts; //array that can be modified. it only holds post objects

    public ListPosts(){
        allPosts = new ArrayList<>(); //instantiating your list as an array list
    }

    @Override
    public List<Post> getAllPosts() {
        return allPosts;
    }

    @Override
    public void savePost(Post post) {
        post.setId(allPosts.size()+1);
        allPosts.add(post);
    }

}
