package dev.spring.service.impl;

import dev.spring.dao.UserDao;
import dev.spring.model.User;
import dev.spring.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.create(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.getAll();
    }
}
