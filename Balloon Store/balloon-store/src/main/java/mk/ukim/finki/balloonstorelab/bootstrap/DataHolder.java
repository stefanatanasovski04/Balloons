package mk.ukim.finki.balloonstorelab.bootstrap;

import mk.ukim.finki.balloonstorelab.model.Balloon;
import mk.ukim.finki.balloonstorelab.model.Manufacturer;
import mk.ukim.finki.balloonstorelab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloonList = new ArrayList<>(10);
    public static List<Order> orderList= new ArrayList<>(10);

    public static List<Manufacturer> manufacturerList = new ArrayList<>(10);

    @PostConstruct
    public void init(){
        Manufacturer manufacturer1 = new Manufacturer("Manufacturer1","Macedonia","Partizanska 35");
        Manufacturer manufacturer2 = new Manufacturer("Manufacturer2","Macedonia","Partizanska 455");
        manufacturerList.add(manufacturer1);
        manufacturerList.add(manufacturer2);
        balloonList.add(new Balloon("Red Balloon","Large",manufacturer1));
        balloonList.add(new Balloon("Blue Balloon","Large",manufacturer2));
    }
}
