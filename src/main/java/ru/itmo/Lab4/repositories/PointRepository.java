package ru.itmo.Lab4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itmo.Lab4.model.Point;
import ru.itmo.Lab4.model.User;

import java.util.Collection;

public interface PointRepository extends JpaRepository<Point, Long> {
    @Query("SELECT u FROM Point u WHERE u.user = ?1")
    Collection<Point> findAllUserPoints(User user);
}
