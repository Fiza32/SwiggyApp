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
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	
	@NotNull(message = "restaurantName should not be null")
	private String restaurantName;
	
	@NotNull(message = "address should not be null")
	private String address;
	
	@OneToMany
	private List<Orders> orders;
	
	@ManyToMany
	private List<DeliveryPartner> deliveryPartners;
	
	public Restaurant() {
		super();
	}

	public Restaurant(int restaurantId, String restaurantName, String address, List<Orders> orders,
			List<DeliveryPartner> deliveryPartners) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.orders = orders;
		this.deliveryPartners = deliveryPartners;
	}

	public int getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
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

	public List<DeliveryPartner> getDeliveryPartners() {
		return deliveryPartners;
	}

	public void setDeliveryPartners(List<DeliveryPartner> deliveryPartners) {
		this.deliveryPartners = deliveryPartners;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + ", orders=" + orders + ", deliveryPartners=" + deliveryPartners + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, deliveryPartners, orders, restaurantId, restaurantName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(address, other.address) && Objects.equals(deliveryPartners, other.deliveryPartners)
				&& Objects.equals(orders, other.orders) && restaurantId == other.restaurantId
				&& Objects.equals(restaurantName, other.restaurantName);
	}
	
	
}
