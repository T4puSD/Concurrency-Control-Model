package com.tapusd.ccmodel.repository;

import com.tapusd.ccmodel.domain.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier,Long> {
}
