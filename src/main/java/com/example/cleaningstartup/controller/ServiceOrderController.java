package com.example.cleaningstartup.controller;

import com.example.cleaningstartup.entity.CleaningServiceOrder;
import com.example.cleaningstartup.repository.CleaningServiceRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("cleaningServiceOrder")
public class ServiceOrderController {
    private CleaningServiceRepository cleaningServiceRepository;

    public ServiceOrderController(CleaningServiceRepository cleaningServiceRepository) {
        this.cleaningServiceRepository = cleaningServiceRepository;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "show-order-page";
    }

    @PostMapping
    public String processOrder(@Valid CleaningServiceOrder order, Errors errors,
                               SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "show-order-page";
        }
        cleaningServiceRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}

