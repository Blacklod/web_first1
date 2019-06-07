package com.ystu.web_first.model;

import com.ystu.web_first.entities.Car;
import com.ystu.web_first.entities.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private static Data data = null;

    public static Data getInstance() {
        if(data == null) {
            data = new Data();
        }
        return data;
    }

    private Data() {
      //  initData();
    }

    ArrayList<Car> guitars = new ArrayList<Car>();
    ArrayList<User> customers = new ArrayList<User>();



}
