package com.tapusd.ccmodel.scheduler;

import com.tapusd.ccmodel.domain.Courier;
import com.tapusd.ccmodel.service.CourierReturnService;
import com.tapusd.ccmodel.service.CourierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class UpdateCourierBalanceScheduler {
    private CourierService courierService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateCourierBalanceScheduler.class);
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yy");

    @Autowired
    public UpdateCourierBalanceScheduler(CourierService courierService) {
        this.courierService = courierService;
    }

    @Scheduled(fixedRate = 1000 * 60)
    public void updateAllCourierBalance(){
        List<Courier> courierList = courierService.getAllCourier();
        LOGGER.info("Updating All courier Balance: " + simpleDateFormat.format(new Date()));
        for(Courier courier: courierList){
            courierService.updateBalanceForACourier(courier.getId());
        }
        LOGGER.info("Done Updating All courier Balance: " + simpleDateFormat.format(new Date()));
    }
}
