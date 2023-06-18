package mk.ukim.finki.balloonstorelab.service.impl;

import mk.ukim.finki.balloonstorelab.model.Order;
import mk.ukim.finki.balloonstorelab.repository.OrderRepository;
import mk.ukim.finki.balloonstorelab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        if (balloonColor == null || balloonColor.isEmpty() ||
        clientName == null || clientName.isEmpty() ||
        address.isEmpty() || address == null){
            return null;
        }
        Order order = new Order(balloonColor,clientName,address);
        this.orderRepository.save(order);
        return order;

    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAllOrders();
    }
}
