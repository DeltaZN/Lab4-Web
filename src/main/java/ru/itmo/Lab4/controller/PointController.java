package ru.itmo.Lab4.controller;

import org.springframework.web.bind.annotation.*;
import ru.itmo.Lab4.model.Graphic;
import ru.itmo.Lab4.model.data.Point;
import ru.itmo.Lab4.repositories.PointRepository;
import ru.itmo.Lab4.repositories.UserRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class PointController {
    private final PointRepository pointRepository;
    private final UserRepository userRepository;
    private final Graphic graphic;

    PointController(PointRepository pointRepository, UserRepository userRepository, Graphic graphic) {
        this.pointRepository = pointRepository;
        this.graphic = graphic;
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @GetMapping("/points")
    Collection<Point> allPoints(Principal user) {
        System.out.println("all points request from "+user.getName());
        return pointRepository.findAllUserPoints(userRepository.findByUsername(user.getName()));
    }

    @CrossOrigin
    @PostMapping("/points")
    Point newPoint(@RequestBody Point newPoint, Principal user) {
        newPoint.setResult(graphic.isInArea(newPoint));
        newPoint.setUser(userRepository.findByUsername(user.getName()));
        return pointRepository.save(newPoint);
    }


    @CrossOrigin
    @GetMapping("/points/{r}")
    Collection<Point> allPointsRecalculation(@PathVariable Double r, Principal user) {
        List<Point> recalculated = new ArrayList<>();
        Collection<Point> points = pointRepository.findAllUserPoints(userRepository.findByUsername(user.getName()));

        for (Point p : points) {
            Point point = new Point(p.getX(), p.getY(), r, false);
            point.setResult(graphic.isInArea(point));
            recalculated.add(point);
        }

        return recalculated;
    }

//    @CrossOrigin
//    @PutMapping("/points/{id}")
//    Point replacePoint(@RequestBody Point newPoint, @PathVariable Long id) {
//
//        return pointRepository.findById(id)
//                .map(point -> {
//                    point.setX(newPoint.getX());
//                    point.setY(newPoint.getY());
//                    point.setR(newPoint.getR());
//                    point.setInArea(graphic.isInArea(newPoint));
//                    return pointRepository.save(point);
//                })
//                .orElseGet(() -> {
//                    newPoint.setInArea(graphic.isInArea(newPoint));
//                    newPoint.setId(id);
//                    return pointRepository.save(newPoint);
//                });
//    }

//    @CrossOrigin
//    @DeleteMapping("/points/{id}")
//    void deletePoint(@PathVariable Long id) {
//        pointRepository.deleteById(id);
//    }
}
