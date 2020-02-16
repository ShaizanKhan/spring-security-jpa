package com.shaizankhan.springsecurityjpa.repository;

import com.shaizankhan.springsecurityjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Shaizan.Khan
 * created on 16-02-2020
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);
}
