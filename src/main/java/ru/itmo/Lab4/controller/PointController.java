package ru.itmo.Lab4.controller;

import org.springframework.web.bind.annotation.*;
import ru.itmo.Lab4.data.Point;
import ru.itmo.Lab4.model.Graphic;
import ru.itmo.Lab4.repositories.PointRepository;

import java.util.List;

@RestController
public class PointController {
    private final PointRepository repository;
    private final Graphic graphic;

    PointController(PointRepository repository, Graphic graphic) {
        this.repository = repository;
        this.graphic = graphic;
    }

    @GetMapping("/points")
    List<Point> allPoints() {
        return repository.findAll();
    }

    @PostMapping("/points")
    Point newPoint(@RequestBody Point newPoint) {
        newPoint.setHit(graphic.isHit(newPoint));
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
                    point.setHit(graphic.isHit(newPoint));
                    return repository.save(point);
                })
                .orElseGet(() -> {
                    newPoint.setHit(graphic.isHit(newPoint));
                    newPoint.setId(id);
                    return repository.save(newPoint);
                });
    }

    @DeleteMapping("/points/{id}")
    void deletePoint(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
