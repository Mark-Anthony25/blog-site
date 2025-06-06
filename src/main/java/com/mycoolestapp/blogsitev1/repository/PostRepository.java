package com.mycoolestapp.blogsitev1.repository;

import com.mycoolestapp.blogsitev1.entity.PostBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostBlog, Long> {

}
