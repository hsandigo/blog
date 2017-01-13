package com.codeup;

import com.codeup.authorization.User;
import com.codeup.dao.Posts;
import com.codeup.models.Post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/posts")

public class PostsController extends BaseController {

    @Autowired
    private Posts postsDao;

    @GetMapping
    public String showPosts(Model model){
        List<Post> posts = postsDao.findAll();
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

        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String individualShowPage(Model model, @PathVariable int id) {
        Post post = postsDao.findById(id);
        User user = loggedInUser();
        boolean isPostingUser = false;
        if(user != null){
            isPostingUser = post.getUser().getId() == user.getId();
        }
        model.addAttribute("post", post);
        model.addAttribute("isPostingUser", isPostingUser);
        return "posts/show";
    }

    @GetMapping("/{id}/edit")
    public String editPost(Model model, @PathVariable int id) {
        Post post = postsDao.findById(id);
        User user = loggedInUser();
        if(loggedInUser() == null){
            return "redirect:/posts/" + id;
        }else if(post.getUser().getId() != loggedInUser().getId()){
            return "redirect:/posts/" + id;
        }
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
        Post existingPost = postsDao.findById(id);
        existingPost.setTitle(post.getTitle());
        existingPost.setBody(post.getBody());
        postsDao.save(existingPost);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable int id) {
        Post post = postsDao.findById(id);
        postsDao.delete(post);
        return "redirect:/posts";
    }
}