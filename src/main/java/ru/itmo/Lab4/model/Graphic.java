package ru.itmo.Lab4.model;

import org.springframework.stereotype.Component;
import ru.itmo.Lab4.data.Point;

@Component
public class Graphic {
    public boolean isHit(double x, double y, double r) {
        boolean triangle = x <= 0 && y >= 0 && y <= (x + r)/2;
        boolean square = x >= 0 && y >= 0 && x <= r && y <= r/2;
        boolean sector = x >= 0 && y <= 0 && Math.sqrt(x*x + y*y) <= r;
        return triangle || square || sector;
    }

    public boolean isHit(Point point) {
        return isHit(point.getX(), point.getY(), point.getR());
    }
}
