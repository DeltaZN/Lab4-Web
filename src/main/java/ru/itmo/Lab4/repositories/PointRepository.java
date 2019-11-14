package ru.itmo.Lab4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.Lab4.model.Point;

public interface PointRepository extends JpaRepository<Point, Long> { }
