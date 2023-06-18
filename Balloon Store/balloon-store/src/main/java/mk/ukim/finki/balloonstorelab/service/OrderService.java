package mk.ukim.finki.balloonstorelab.service;

import mk.ukim.finki.balloonstorelab.model.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(String balloonColor, String clientName, String address);

    List<Order> findAll();

}
