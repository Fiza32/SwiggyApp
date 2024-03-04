package com.masai.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private List<String> items;
	
    @PositiveOrZero(message = "Total amount must be a positive number or zero")
	private double totalAmount;
	
    @Enumerated
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	private Restaurant restaurant;
	
	@ManyToOne
	private DeliveryPartner deliveryPartner;
	
	public Orders() {
		super();
	}

	public Orders(int orderId, List<String> items, double totalAmount, Status status, Customer customer,
			Restaurant restaurant, DeliveryPartner deliveryPartner) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.totalAmount = totalAmount;
		this.status = status;
		this.customer = customer;
		this.restaurant = restaurant;
		this.deliveryPartner = deliveryPartner;
	}

	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public DeliveryPartner getDeliveryPartner() {
		return deliveryPartner;
	}

	public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
		this.deliveryPartner = deliveryPartner;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", items=" + items + ", totalAmount=" + totalAmount + ", status=" + status
				+ ", customer=" + customer + ", restaurant=" + restaurant + ", deliveryPartner=" + deliveryPartner
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, deliveryPartner, items, orderId, restaurant, status, totalAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(deliveryPartner, other.deliveryPartner)
				&& Objects.equals(items, other.items) && orderId == other.orderId
				&& Objects.equals(restaurant, other.restaurant) && status == other.status
				&& Double.doubleToLongBits(totalAmount) == Double.doubleToLongBits(other.totalAmount);
	}
}
