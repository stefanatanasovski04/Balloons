package mk.ukim.finki.balloonstorelab.web.servlet;

import mk.ukim.finki.balloonstorelab.service.BalloonService;
import mk.ukim.finki.balloonstorelab.service.ManufacturerService;
import mk.ukim.finki.balloonstorelab.service.OrderService;
import mk.ukim.finki.balloonstorelab.model.Manufacturer;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "confirmation-info", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final BalloonService balloonService;

    private final OrderService orderService;

    private final ManufacturerService manufacturerService;

    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(BalloonService balloonService, OrderService orderService, ManufacturerService manufacturerService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.orderService = orderService;
        this.manufacturerService = manufacturerService;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp, req.getServletContext());
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");
        req.getSession().setAttribute("ipAddress",ipAddress);
        req.getSession().setAttribute("clientAgent",clientAgent);
        this.springTemplateEngine.process("confirmationInfo.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getSession().getAttribute("color");
        String desc = (String) req.getSession().getAttribute("size");
        String clientName = (String) req.getSession().getAttribute("clientName") ;
        String clientAddress = (String) req.getSession().getAttribute("clientAddress");
        this.orderService.placeOrder(name,clientName,clientAddress);
        req.getSession().setAttribute("orders",this.orderService.findAll());
        List< Manufacturer> man = this.manufacturerService.findAll();
        this.balloonService.saveBallon(name,desc,man.get(0).getId());
        resp.sendRedirect("/balloons");
    }
}
