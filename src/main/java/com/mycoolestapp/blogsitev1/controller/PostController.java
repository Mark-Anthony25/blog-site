package com.mycoolestapp.blogsitev1.controller;


import com.mycoolestapp.blogsitev1.entity.PostBlog;
import com.mycoolestapp.blogsitev1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/getAllPosts")
    public List<PostBlog> getAllPosts(){
    return postService.getAllPosts();
    }
    @GetMapping("/getPostby/{id}")
    public PostBlog getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }
    @PostMapping("/createPost")
    public PostBlog createPost(@RequestBody PostBlog post) {
        return postService.createPost(post);
    }
    @PutMapping("/updatePost/{id}")
    public ResponseEntity<PostBlog> updatePost (@PathVariable Long id , @RequestBody PostBlog post) {
        try {
            PostBlog updatePost = postService.updatePost(id, post);
            return ResponseEntity.ok(updatePost);
        }
        catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
