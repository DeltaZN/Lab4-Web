package ru.itmo.Lab4.service;

import ru.itmo.Lab4.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
