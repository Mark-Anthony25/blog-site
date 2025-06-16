package com.mycoolestapp.blogsitev1.controller;

import com.mycoolestapp.blogsitev1.entity.PostBlog;
import com.mycoolestapp.blogsitev1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class WebViewController {

    @Autowired
    private PostService postService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "index"; // This should resolve to index.html
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/blog/home";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/blog/home"; // Redirect to avoid circular view path
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        PostBlog post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/posts/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new PostBlog());
        return "post-form";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        PostBlog post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post-form";
    }

    @PostMapping("/posts/save")
    public String savePost(@ModelAttribute PostBlog post) {
        if (post.getId() == null) {
            postService.createPost(post);
        } else {
            postService.updatePost(post.getId(), post);
        }
        return "redirect:/blog/home"; // Redirect to home after saving
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/blog/home"; // Redirect to home after deletion
    }
}
