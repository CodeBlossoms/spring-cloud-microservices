package com.ggk.sixt.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "cars")
@Proxy(lazy = false)
public class Car {
	
	private int carId;
	private String model;
	private Long rentPerHr;
	
	@Id
	@Column(name = "car_id")
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Long getRentPerHr() {
		return rentPerHr;
	}
	public void setRentPerHr(Long rentPerHr) {
		this.rentPerHr = rentPerHr;
	}
	
	
	
}
