package com.tapusd.ccmodel.repository;

import com.tapusd.ccmodel.domain.Courier;
import com.tapusd.ccmodel.domain.CourierReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierReturnRepository extends JpaRepository<CourierReturn, Long> {
    List<CourierReturn> findAllByCourier(Courier courier);
    List<CourierReturn> findAllByCourier_Id(Long courierId);
}
