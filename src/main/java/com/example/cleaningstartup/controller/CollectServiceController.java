package com.example.cleaningstartup.controller;


import com.example.cleaningstartup.entity.CleaningService;
import com.example.cleaningstartup.entity.CleaningServiceItem;
import com.example.cleaningstartup.entity.CleaningServiceItem.*;
import com.example.cleaningstartup.entity.CleaningServiceOrder;
import com.example.cleaningstartup.repository.CleaningServiceItemRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Slf4j
@Controller
@RequestMapping("/services-page")
@SessionAttributes("cleaningServiceOrder")
public class CollectServiceController {

    private final CleaningServiceItemRepository cleaningServiceItemRepository;

    @Autowired
    public CollectServiceController(
            CleaningServiceItemRepository cleaningServiceItemRepository){
    this.cleaningServiceItemRepository = cleaningServiceItemRepository;
    }

    @ModelAttribute
    public void addCleaningServiceItems(Model model){
        Iterable<CleaningServiceItem> cleaningServiceItems = cleaningServiceItemRepository.findAll();
        Type[] types = CleaningServiceItem.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(cleaningServiceItems, type));
        }
    }

    @ModelAttribute(name="cleaningServiceOrder")
    public CleaningServiceOrder order(){
        return new CleaningServiceOrder();
    }

    @ModelAttribute(name="cleaningService")
    public CleaningService cleaningService(){
        return new CleaningService();
    }

    @GetMapping
    public String showCollectServiceOrder() {
        return "services-page";
    }

    @PostMapping
    public String processCleaningService(
            @Valid CleaningService cleaningService, Errors errors,
            @ModelAttribute CleaningServiceOrder cleaningServiceOrder) {

        if (errors.hasErrors()) {
            return "services-page";
        }
        cleaningServiceOrder.addCleaningService(cleaningService);
        log.info("Processing cleaningService:{}", cleaningService);
        return "redirect:/orders/current";
    }

    private Iterable<CleaningServiceItem> filterByType(
            Iterable<CleaningServiceItem> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
