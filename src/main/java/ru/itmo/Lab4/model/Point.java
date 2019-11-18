package ru.itmo.Lab4.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "points")
public class Point {
    private @Id @GeneratedValue Long id;
    private Double x;
    private Double y;
    private Double r;
    private Boolean inArea;

    @ManyToOne
    private User user;

    public Point() {}

    public Point(double x, double y, double r, boolean inArea) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.inArea = inArea;
    }
}
