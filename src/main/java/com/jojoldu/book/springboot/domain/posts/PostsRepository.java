package com.jojoldu.book.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Long>{
    //Optional<Posts> findById(Long id);
}