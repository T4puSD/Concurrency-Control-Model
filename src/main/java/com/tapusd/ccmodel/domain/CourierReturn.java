package com.tapusd.ccmodel.domain;


import javax.persistence.*;

@Entity
public class CourierReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long returnCharge;
    private ReturnType returnType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Courier courier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReturnCharge() {
        return returnCharge;
    }

    public void setReturnCharge(Long returnCharge) {
        this.returnCharge = returnCharge;
    }

    public ReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType = returnType;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
