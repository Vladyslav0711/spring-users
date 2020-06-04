package dev.spring.dao;

import dev.spring.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    void create(User user);

    List<User> getAll();

    Optional<User> getById(Long id);
}
