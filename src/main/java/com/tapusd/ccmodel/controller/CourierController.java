package com.tapusd.ccmodel.controller;

import com.tapusd.ccmodel.domain.Courier;
import com.tapusd.ccmodel.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("couriers")
public class CourierController {
    private CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping("/")
    public Courier addCourier(@RequestBody Courier courier){
       return courierService.addCourier(courier.getCourierName(),courier.getBookingMoney(),courier.getReturnChargePercentage());
    }

    @GetMapping("/{courierId}")
    public Courier getCourierById(@PathVariable Long courierId){
        return courierService.findCourierById(courierId);
    }

    @PostMapping("/{courierId}/update-balance")
    public Courier updateBalanceForCourierId(@PathVariable Long courierId){
        courierService.updateBalanceForACourier(courierId);
        return courierService.findCourierById(courierId);
    }
}
