package com.masai.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.DeliveryException;
import com.masai.exception.OrderException;
import com.masai.exception.RestaurantException;
import com.masai.model.Customer;
import com.masai.model.DeliveryPartner;
import com.masai.model.Orders;
import com.masai.model.Restaurant;
import com.masai.model.Status;
import com.masai.repository.CustomerRepository;
import com.masai.repository.DeliveryRepository;
import com.masai.repository.OrderRepository;
import com.masai.repository.RestaurantRepository;


@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private DeliveryRepository deliveryRepo;

	@Override
	public Orders addOrder(Orders order, int restaurantId, int customerId, int deliveryId)
			throws OrderException, CustomerException, RestaurantException {
		if(order == null) {
			throw new OrderException("Your order is null, Please provide the valid data");
		}
		
		if(orderRepo.findById(order.getOrderId()).isPresent()) {
			throw new OrderException("Order already exist with the id " + order.getOrderId());
		}
		
		Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow(() -> new RestaurantException("Restaurant with id " + restaurantId + " not found"));
		
		Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer with id " + customerId + " not found"));
		
		DeliveryPartner deliveryPartner = deliveryRepo.findById(deliveryId).orElseThrow(() -> new DeliveryException("Delivery with id " + deliveryId + " not found"));
		order.setCustomer(customer);
		order.setRestaurant(restaurant);
		order.setDeliveryPartner(deliveryPartner);
		
		Orders savedOrder = orderRepo.save(order);
		
		return savedOrder;
	}

	
	@Override
	public Orders getOrder(int orderId) throws OrderException {
		Orders order = orderRepo.findById(orderId).orElseThrow(() -> new OrderException("Order with id " + orderId + " not found"));
		
		return order;
	}

	@Override
	public Orders updateOrder(int orderId, Status status) throws OrderException {
		Orders order = orderRepo.findById(orderId).orElseThrow(() -> new OrderException("Order with id " + orderId + " not found"));
		
		order.setStatus(status);
		Orders updatedOrders = orderRepo.save(order);
		
		return updatedOrders;
	}

	@Override
	public Orders deleteOrder(int orderId) throws OrderException {
		Orders order = orderRepo.findById(orderId).orElseThrow(() -> new OrderException("Order with id " + orderId + " not found"));
		
		orderRepo.delete(order);
		
		return order;
	}

	@Override
	public Orders orderByCustomerId(int customerId) throws OrderException {
		Orders order = orderRepo.findByCustomer_CustomerId(customerId);
		
		if(order == null) {
			throw new CustomerException("Order with customer id " + customerId + " not found");
		}
		
		return order;
	}
}
