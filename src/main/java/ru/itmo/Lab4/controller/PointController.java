package ru.itmo.Lab4.controller;

import org.springframework.web.bind.annotation.*;
import ru.itmo.Lab4.data.Point;
import ru.itmo.Lab4.repositories.PointRepository;

import java.util.List;

@RestController
public class PointController {
    private final PointRepository repository;

    PointController(PointRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/points")
    List<Point> allPoints() {
        return repository.findAll();
    }

    @PostMapping("/points")
    Point newPoint(@RequestBody Point newPoint) {
        return repository.save(newPoint);
    }


    @GetMapping("/points/{id}")
    Point onePoint(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PointNotFoundException(id));
    }

    @PutMapping("/points/{id}")
    Point replacePoint(@RequestBody Point newPoint, @PathVariable Long id) {

        return repository.findById(id)
                .map(point -> {
                    point.setX(newPoint.getX());
                    point.setY(newPoint.getY());
                    point.setR(newPoint.getR());
                    point.setHit(newPoint.getHit());
                    return repository.save(point);
                })
                .orElseGet(() -> {
                    newPoint.setId(id);
                    return repository.save(newPoint);
                });
    }

    @DeleteMapping("/points/{id}")
    void deletePoint(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
