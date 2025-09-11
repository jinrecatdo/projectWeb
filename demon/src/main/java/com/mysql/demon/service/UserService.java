package com.mysql.demon.service;

import com.mysql.demon.Dao.UserRepo;
import com.mysql.demon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private User user;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User getUser(int id) {
      return   repo.findById(id).orElse(new User());
    }
}
