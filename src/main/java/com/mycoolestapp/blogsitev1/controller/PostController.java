package com.mycoolestapp.blogsitev1.controller;


import com.mycoolestapp.blogsitev1.entity.PostBlog;
import com.mycoolestapp.blogsitev1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostBlog> getAllPosts(){
    return postService.getAllPosts();
    }
    public PostBlog getPostById(Long postId) {
        return postService.getPostById(postId);
    }

    public PostBlog createPost(PostBlog post) {
        return postService.createPost(post);
    }

}
