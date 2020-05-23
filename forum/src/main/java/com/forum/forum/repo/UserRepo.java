package com.forum.forum.repo;


import com.forum.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByNameAndEmail(String name, String email);
    boolean existsByEmail(String email);
    User findByEmail(String email);
}
