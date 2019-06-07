package com.ystu.web_first.entities;

public class Car {

    private long id;
    private String name;
    private String color;
    private String engine;
    private String kp;
    private double price;

    public Car(long id, String name, String color, String engine, String kp, double price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this. engine = engine;
        this.kp = kp;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
