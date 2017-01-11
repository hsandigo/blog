package com.codeup;

import com.codeup.dao.DaoFactory;
import com.codeup.models.Post;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String createNewPost(@Valid Post post, Errors validation, Model model){
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }

        DaoFactory.getPostsDao().savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String individualShowPage(Model model, @PathVariable int id) {
        Post post = DaoFactory.getPostsDao().getPostById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/{id}/edit")
    public String editPost(Model model, @PathVariable int id) {
        Post post = DaoFactory.getPostsDao().getPostById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }
    @PostMapping("/{id}/edit")
    public String editPost(@Valid Post post, Errors validation, Model model, @PathVariable int id)  {
        if(validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/edit";
        }
        Post existingPost = DaoFactory.getPostsDao().getPostById(id);
        existingPost.setTitle(post.getTitle());
        existingPost.setBody(post.getBody());
        DaoFactory.getPostsDao().updatePost(existingPost);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable int id) {
        Post post = DaoFactory.getPostsDao().getPostById(id);
        DaoFactory.getPostsDao().deletePost(post);
        return "redirect:/posts";
    }
}
