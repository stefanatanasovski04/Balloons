package mk.ukim.finki.balloonstorelab.web.controller;

import mk.ukim.finki.balloonstorelab.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @GetMapping
    public String getOrdersPage(HttpServletRequest request, Model model){
        List<Order> orders = (List<Order>) request.getSession().getAttribute("orders");
        model.addAttribute("orders",orders);
        return "userOrders";
    }

    @PostMapping
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/balloons";
    }
}
