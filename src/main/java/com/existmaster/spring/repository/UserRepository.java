package com.existmaster.spring.repository;

import com.existmaster.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by existmaster on 2015. 6. 18..
 */
public interface UserRepository extends JpaRepository<User, String> {
}
