package mk.ukim.finki.balloonstorelab.repository;

import mk.ukim.finki.balloonstorelab.bootstrap.DataHolder;
import mk.ukim.finki.balloonstorelab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    public List<Order> findAllOrders(){
        return DataHolder.orderList;
    }

    public Optional<Order> findOrderById(Long id){
        return DataHolder.orderList.stream().filter(i -> i.getOrderId().equals(id)).findFirst();
    }

    public Order save(Order o){
        if (o==null || o.getOrderId() == null ||
        o.getBalloonColor() == null || o.getBalloonColor().isEmpty()
        || o.getBalloonSize() == null || o.getBalloonSize().isEmpty()){
            return null;
        }
        DataHolder.orderList.add(o);
        return o;
    }


}
