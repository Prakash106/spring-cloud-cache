package com.programmingarea.springcloudcache.cache;

import com.programmingarea.springcloudcache.model.User;
import com.programmingarea.springcloudcache.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCache {

    @Autowired
    UserRepository userRepository;

    @Cacheable(value = "usersCache", key="#name")
    public List<User> findByName(String name) {
        System.out.println("Retriving from the database for name:"+ name);
        return userRepository.findByName(name);
    }
}
