package com.tapusd.ccmodel.controller;

import com.tapusd.ccmodel.domain.Courier;
import com.tapusd.ccmodel.service.CourierReturnService;
import com.tapusd.ccmodel.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("couriers")
public class CourierReturnController {
    private CourierReturnService courierReturnService;
    private CourierService courierService;

    @Autowired
    public CourierReturnController(CourierReturnService courierReturnService, CourierService courierService) {
        this.courierReturnService = courierReturnService;
        this.courierService = courierService;
    }

    @PostMapping("return/")
    public void addCourierReturn(@RequestParam(name = "courier_id") Long courierId, @RequestParam(name = "product_amount") Long productAmount){
        Courier courier = courierService.findCourierById(courierId);
        courierReturnService.addReturn(courier,productAmount);
    }

    @PostMapping("complete-return/")
    public void addCourierCompleteReturn(@RequestParam(name = "courier_id") Long courierId, @RequestParam(name = "product_amount") Long productAmount){
        Courier courier = courierService.findCourierById(courierId);
        courierReturnService.addCompleteReturn(courier,productAmount);
    }

}
