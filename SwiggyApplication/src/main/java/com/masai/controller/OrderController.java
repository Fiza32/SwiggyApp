package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.model.Orders;
import com.masai.model.Status;
import com.masai.service.OrderServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderService;
	
//	POST /?restaurantId=123&customerId=456&deliveryId=789
	@PostMapping("/")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order, @RequestParam int restaurantId, @RequestParam int customerId, @RequestParam int deliveryId){
		Orders addedOrders = orderService.addOrder(order, restaurantId, customerId, deliveryId);
		
		return new ResponseEntity<Orders>(addedOrders, HttpStatus.CREATED);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Orders> getOrder(@PathVariable int orderId){
		Orders receivedOrders = orderService.getOrder(orderId);
		
		return new ResponseEntity<Orders>(receivedOrders, HttpStatus.OK);
	}
	
	@PutMapping("/update/")
	public ResponseEntity<Orders> updateOrder(@Valid @RequestParam int orderId, @RequestParam Status status){
		Orders updatedOrders = orderService.updateOrder(orderId, status);
		
		return new ResponseEntity<Orders>(updatedOrders, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable int orderId){
		Orders deletedOrders = orderService.deleteOrder(orderId);
		
		return new ResponseEntity<Orders>(deletedOrders, HttpStatus.OK);
	}
	
	@GetMapping("/byCustomerId/{customerId}")
	public ResponseEntity<Orders> orderByCustomerId(@PathVariable int customerId){
		Orders ordersByCustomers = orderService.orderByCustomerId(customerId);
		
		return new ResponseEntity<Orders>(ordersByCustomers, HttpStatus.OK);
	}
}
