package dev.spring.dao;

import dev.spring.model.User;
import java.util.List;

public interface UserDao {
    void create(User user);

    List<User> getAll();
}
