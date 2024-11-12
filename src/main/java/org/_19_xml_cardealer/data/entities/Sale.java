package org._19_xml_cardealer.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{

    private double discount;


    @ManyToOne
    @JoinColumn(name = "car_id" ,referencedColumnName = "id")
    private Car Car;


    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public org._19_xml_cardealer.data.entities.Car getCar() {
        return Car;
    }

    public void setCar(org._19_xml_cardealer.data.entities.Car car) {
        Car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
