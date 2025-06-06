package com.mycoolestapp.blogsitev1.service;

import com.mycoolestapp.blogsitev1.entity.PostBlog;
import com.mycoolestapp.blogsitev1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
