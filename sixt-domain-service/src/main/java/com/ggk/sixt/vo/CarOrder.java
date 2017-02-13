package com.ggk.sixt.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "rental_orders")
@Proxy(lazy = false)
public class CarOrder {
	
	private int orderId, carId,userId;
	private boolean carRentApproved, carReturnReceived,carReturnApproved;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "order_id")
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	@Column(name = "car_id")
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "car_rent_approved")
	public boolean isCarRentApproved() {
		return carRentApproved;
	}
	public void setCarRentApproved(boolean carRentApproved) {
		this.carRentApproved = carRentApproved;
	}
	
	@Column(name = "car_return_received")
	public boolean isCarReturnReceived() {
		return carReturnReceived;
	}
	public void setCarReturnReceived(boolean carReturnReceived) {
		this.carReturnReceived = carReturnReceived;
	}
	
	@Column(name = "car_return_approved")
	public boolean isCarReturnApproved() {
		return carReturnApproved;
	}
	public void setCarReturnApproved(boolean carReturnApproved) {
		this.carReturnApproved = carReturnApproved;
	}
	
	
	
	
	
	
}
