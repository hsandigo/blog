package com.codeup;

import com.codeup.dao.DaoFactory;
import com.codeup.models.Post;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/posts")

public class PostController {
    @GetMapping
    public String showPosts(Model model){
        List<Post> posts = DaoFactory.getPostsDao().getAllPosts();
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/create")
    public String createNewPosts(@ModelAttribute Post post){
        DaoFactory.getPostsDao().savePost(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id){
        Post post = DaoFactory.getPostsDao().find(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String update(@ModelAttribute Post editedPost, @PathVariable long id){
        Post existingPost = DaoFactory.getPostsDao().find(id);
        String newTitle = editedPost.getTitle();
        String newBody = editedPost.getBody();
        existingPost.setTitle(newTitle);
        existingPost.setBody(newBody);
        DaoFactory.getPostsDao().update(existingPost);
        return "redirect:/posts/" + existingPost.getId();
    }

}

