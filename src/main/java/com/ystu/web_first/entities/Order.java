package com.ystu.web_first.entities;
import java.util.ArrayList;
import java.util.List;
public class Order {
    private long id = 0;

    private long user_id = 0;
    private List<Long> cars = new ArrayList<Long>();
    public Order() {
    }

    public Order(int id, long user_id, List<Long> cars) {
        this.id = id;
        this.user_id = user_id;
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public List<Long> getCars() {
        return cars;
    }

    public void setCars(List<Long> cars) {
        this.cars = cars;
    }
}


