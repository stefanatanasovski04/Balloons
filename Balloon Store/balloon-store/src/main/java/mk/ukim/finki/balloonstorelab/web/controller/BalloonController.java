package mk.ukim.finki.balloonstorelab.web.controller;

import mk.ukim.finki.balloonstorelab.service.BalloonService;
import mk.ukim.finki.balloonstorelab.service.ManufacturerService;
import mk.ukim.finki.balloonstorelab.model.Balloon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;

    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }


    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        if (error !=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        model.addAttribute("balloonList",this.balloonService.listAll());
        return "listBalloons";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id,Model model){
        if (this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).orElseGet(null);
            model.addAttribute("manufacturers",this.manufacturerService.findAll());
            model.addAttribute("balloon",balloon);
            return "add-balloon";
        }else{
            return "redirect:/balloons?error=BalloonNotFound";
        }
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        model.addAttribute("manufacturers",this.manufacturerService.findAll());
        return "add-balloon";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer){
        System.out.println(manufacturer);
        this.balloonService.saveBallon(name,description,manufacturer);
        return "redirect:/balloons";
    }



}
