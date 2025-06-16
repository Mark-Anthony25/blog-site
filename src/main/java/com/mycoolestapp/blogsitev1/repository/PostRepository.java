package com.mycoolestapp.blogsitev1.repository;

import com.mycoolestapp.blogsitev1.entity.PostBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostBlog, Long> {
    // Fixed method signature to match Spring Data JPA naming convention
    List<PostBlog> findByTitleContainingIgnoreCase(String title);
    List<PostBlog> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    // Optional: Add these methods if you need more search functionality
    List<PostBlog> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content);
    List<PostBlog> findAllByOrderByCreatedAtDesc();
}
