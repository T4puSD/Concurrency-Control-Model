package com.tapusd.ccmodel.service;

import com.tapusd.ccmodel.domain.Courier;
import com.tapusd.ccmodel.domain.CourierReturn;
import com.tapusd.ccmodel.domain.ReturnType;
import com.tapusd.ccmodel.repository.CourierRepository;
import com.tapusd.ccmodel.repository.CourierReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourierReturnService {

//    @Autowired
    private CourierReturnRepository courierReturnRepository;
//    @Autowired
//    private CourierService courierService;

    @Autowired
    public CourierReturnService(CourierReturnRepository courierReturnRepository) {
        this.courierReturnRepository = courierReturnRepository;
    }

    @Transactional
    public void addReturn(Courier courier, Long productAmount){
//        Courier courier = courierService.findCourierById(courierId);
        Long returnCharge = Math.round(productAmount * (courier.getBookingMoney() * courier.getReturnChargePercentage()));

        CourierReturn courierReturn = new CourierReturn();
        courierReturn.setCourier(courier);
        courierReturn.setReturnType(ReturnType.RETURN);
        courierReturn.setReturnCharge(returnCharge);

        courierReturnRepository.save(courierReturn);
    }

    @Transactional
    public void addCompleteReturn(Courier courier, Long productAmount){
//        Courier courier = courierService.findCourierById(courierId);
        Long returnCharge = Math.round(productAmount * (courier.getBookingMoney() * courier.getReturnChargePercentage()));

        CourierReturn courierReturn = new CourierReturn();
        courierReturn.setCourier(courier);
        courierReturn.setReturnType(ReturnType.COMPLETE_RETURN);
        courierReturn.setReturnCharge(returnCharge * -1);

        courierReturnRepository.save(courierReturn);
    }

    public List<CourierReturn> getCourierReturnByCourierId(Long courierId){
//        Courier courier = courierService.findCourierById(courierId);
//        return courierReturnRepository.findAllByCourier(courier);
        return courierReturnRepository.findAllByCourier_Id(courierId);
    }
}
