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
    public PostBlog deletePost(Long id) {
        PostBlog deletePost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        postRepository.delete(deletePost);
        return deletePost;
    }
    public List<PostBlog> searchPosts(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);

    }
    public List<PostBlog> getPostsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        if(startDate.isAfter(endDate)){
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        return postRepository.findByCreatedAtBetween(startDate, endDate);
    }

}
