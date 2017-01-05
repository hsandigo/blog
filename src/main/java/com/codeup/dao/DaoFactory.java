package com.codeup.dao;

public class DaoFactory {
    private static Posts postsDao;

    public static Posts getPostsDao(){
        if (postsDao == null){
            postsDao = new ListPosts();
        }
        return postsDao;
    }
}
