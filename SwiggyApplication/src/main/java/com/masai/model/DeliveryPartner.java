package com.masai.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class DeliveryPartner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryId;
	
	@NotNull(message = "deliveryName should not be null")
	private String deliveryName;
	
	@NotNull(message = "address should not be null")
	private String address;
	
	@OneToMany
	private List<Orders> orders;
	
	@ManyToMany
	private Restaurant restaurants;

	public DeliveryPartner() {
		super();
	}

	public DeliveryPartner(int deliveryId, String deliveryName, String address, List<Orders> orders, Restaurant restaurant) {
		super();
		this.deliveryId = deliveryId;
		this.deliveryName = deliveryName;
		this.address = address;
		this.orders = orders;
		this.restaurants = restaurant;
	}

	public int getDeliveryId() {
		return deliveryId;
	}
	
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Restaurant getRestaurant() {
		return restaurants;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurants = restaurant;
	}

	@Override
	public String toString() {
		return "DeliveryPartner [deliveryId=" + deliveryId + ", deliveryName=" + deliveryName + ", address=" + address
				+ ", orders=" + orders + ", restaurant=" + restaurants + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, deliveryId, deliveryName, orders, restaurants);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryPartner other = (DeliveryPartner) obj;
		return Objects.equals(address, other.address) && deliveryId == other.deliveryId
				&& Objects.equals(deliveryName, other.deliveryName) && Objects.equals(orders, other.orders)
				&& Objects.equals(restaurants, other.restaurants);
	}
}
