package com.mycoolestapp.blogsitev1.service;

import com.mycoolestapp.blogsitev1.entity.PostBlog;
import com.mycoolestapp.blogsitev1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostBlog> getAllPosts() {
        return postRepository.findAll();
    }
    public PostBlog getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
    public PostBlog createPost(PostBlog post) {
        return postRepository.save(post);
    }
    public PostBlog updatePost(Long id , PostBlog post) {
        PostBlog existingPost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());

        existingPost.setUpdatedAt(LocalDateTime.now());

        return postRepository.save(existingPost);
    }

}
