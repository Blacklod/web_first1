package com.ystu.web_first.model;

import com.ystu.web_first.entities.Order;
import com.ystu.web_first.entities.User;
import com.ystu.web_first.entities.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    ArrayList<Car> cars = new ArrayList<Car>();
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Order> orders = new ArrayList<Order>();
    //private List<User> users;
    //private List<Car> cars;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        //users = new ArrayList<>();
        initData();
    }

    public void add(User user) {
        users.add(user);
    }

    public List<String> list() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    /*public List<String> list2() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }*/

    public  User getUserByLogPas(String log, String pass) {
        for (User us : users){
            if ((us.getName().equals(log)) && (us.getPassword().equals(pass)) ){
                return us;
            }
        }
        return null;
    }

    //получить id покупателя по логину и паролю
    public Long getIdUserByLogPas(String log, String pass) {
        for (User us : users){
            if ((us.getName().equals(log)) && (us.getPassword().equals(pass)) ){
                return us.getId();
            }
        }
        return null;
    }

    //проверка на правильность логина и пароля
    public  boolean getLogin(String log, String pass) {
        for (User us : users){
            if ((us.getName().equals(log)) && (us.getPassword().equals(pass))){
                return false;
            }
        }
        return true;
    }

    public  ArrayList<Car> getCars() {
        return cars;
    }

    //получить машину по ее id
    public  Car getCarById(long id) {
        for (Car car : cars){
            if (car.getId() == id){
                return car;
            }
        }
        return null;
    }

    //установить заказ
    public  void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    //получить заказ по его id
    public  Order getOrderById(long id) {
        for (Order or : orders){
            if (or.getId() == id){
                return or;
            }
        }
        return new Order();
    }

    public int getSizeCustomers()
    {
        return users.size();
    }

    //получить заказ по id прользователя
    public  Order getOrderByUser(long idUser) {
        for (Order or : orders){
            if (or.getUser_id() == idUser){
                return or;
            }
        }
        return new Order();
    }

    public void initData()
    {
        users.add(new User("Klod","456", (long) 1));
        users.add(new User("Alex","1234", (long) 2));

        cars.add(new Car(1,"VW Polo","Silver","1.6 X 110", "Механика", 670000));
        cars.add(new Car(2,"VW Touareg","White","3.0 X 270", "Робот", 2500000));
        cars.add(new Car(3,"VW Vento","Black","1.8 X 90", "Механика", 100000));
        cars.add(new Car(4,"VW Passat","Red","2.0 X 150", "Автомат", 1600000));
    }

}
