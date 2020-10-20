package com.tapusd.ccmodel.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String courierName;
    @Column(nullable = false)
    private Long bookingMoney;
    @Column(nullable = false)
    private Double returnChargePercentage;
    private Long balance;
    private Date createdAt;
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public Long getBookingMoney() {
        return bookingMoney;
    }

    public void setBookingMoney(Long bookingMoney) {
        this.bookingMoney = bookingMoney;
    }

    public Double getReturnChargePercentage() {
        return returnChargePercentage;
    }

    public void setReturnChargePercentage(Double returnChargePercentage) {
        this.returnChargePercentage = returnChargePercentage;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", courierName='" + courierName + '\'' +
                ", bookingMoney=" + bookingMoney +
                ", returnChargePercentage=" + returnChargePercentage +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
