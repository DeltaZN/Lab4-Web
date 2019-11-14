package ru.itmo.Lab4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.Lab4.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
