package com.shaizankhan.springsecurityjpa.service;

import com.shaizankhan.springsecurityjpa.model.MyUserDetails;
import com.shaizankhan.springsecurityjpa.model.User;
import com.shaizankhan.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Shaizan.Khan
 * created on 16-02-2020
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not Found:" +userName));
        return user.map(MyUserDetails::new).get();
    }
}
