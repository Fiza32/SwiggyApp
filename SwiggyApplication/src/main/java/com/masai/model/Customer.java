package com.masai.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@NotNull(message = "Username should not be null")
	@Size(min = 3, max = 40, message = "Username must be between 3 to 40 characters")
	private String username;
	
	@Email(message = "Invalid email format")
	private String email;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();

	public Customer() {
		super();
	}

	public Customer(int customerId, String username, String email, List<Orders> orders) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.email = email;
		this.orders = orders;
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", email=" + email + ", orders="
				+ orders + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, email, orders, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customerId == other.customerId && Objects.equals(email, other.email)
				&& Objects.equals(orders, other.orders) && Objects.equals(username, other.username);
	}
}
