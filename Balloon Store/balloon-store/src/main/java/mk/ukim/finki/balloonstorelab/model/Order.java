package mk.ukim.finki.balloonstorelab.model;

import lombok.Data;

@Data
public class Order {

    private String balloonColor;

    private String balloonSize;

    private String clientName;

    private String clientAddress;

    private Long orderId;

    public Order(String balloonColor, String clientName, String clientAddress) {
        this.orderId = (long)(Math.random()*1000);
        this.balloonColor = balloonColor;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

}
