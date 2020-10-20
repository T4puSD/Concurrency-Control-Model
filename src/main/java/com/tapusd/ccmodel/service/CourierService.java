package com.tapusd.ccmodel.service;


import com.tapusd.ccmodel.domain.Courier;
import com.tapusd.ccmodel.domain.CourierReturn;
import com.tapusd.ccmodel.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CourierService {
//    @Autowired
    private CourierRepository courierRepository;
//    @Autowired
    private CourierReturnService courierReturnService;

    @Autowired
    public CourierService(CourierRepository courierRepository, CourierReturnService courierReturnService) {
        this.courierRepository = courierRepository;
        this.courierReturnService = courierReturnService;
    }

    @Transactional
    public Courier addCourier(String courierName, Long bookingMoney, Double returnChargePercentage){
        Courier courier = new Courier();
        courier.setCourierName(courierName);
        courier.setBookingMoney(bookingMoney);
        courier.setReturnChargePercentage(returnChargePercentage);
        courier.setCreatedAt(new Date());
        courier.setUpdatedAt(new Date());
        courier.setBalance(0L);

        return courierRepository.save(courier);
    }

    public Courier findCourierById(Long courierId){
        return courierRepository.findById(courierId).orElseThrow(
                ()-> new IllegalArgumentException("No courier found with the id")
        );
    }


    @Transactional
    public void updateBalanceForACourier(Long courierId){
        Courier courier = courierRepository.findById(courierId).orElseThrow(
                ()-> new IllegalArgumentException("No courier found with the id")
        );

        List<CourierReturn> courierReturnList = courierReturnService.getCourierReturnByCourierId(courierId);

        long balance = 0;
        for(CourierReturn courierReturn: courierReturnList){
           balance += courierReturn.getReturnCharge();
        }

        courier.setBalance(balance);
        courier.setUpdatedAt(new Date());

        courierRepository.save(courier);
    }

    public List<Courier> getAllCourier(){
        return courierRepository.findAll();
    }
}
