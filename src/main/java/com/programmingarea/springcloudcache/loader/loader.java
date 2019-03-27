package com.programmingarea.springcloudcache.loader;

import com.programmingarea.springcloudcache.model.User;
import com.programmingarea.springcloudcache.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class loader {

    @Autowired
    UserRepository usersRepository;

    @PostConstruct
    public void load() {
        List<User> usersList = getList();
        usersRepository.saveAll(usersList);
    }

    public List<User> getList() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("Paras", "Developer", "1"));
        usersList.add(new User("Arun", "Deployment", "2"));
        usersList.add(new User("Surya", "UI", "2"));
        return usersList;

    }
}