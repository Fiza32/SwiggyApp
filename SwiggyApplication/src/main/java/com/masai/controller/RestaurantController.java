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

import com.masai.model.Restaurant;
import com.masai.service.RestaurantServiceImpl;

@Controller
@RequestMapping("/api/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantServiceImpl restraService;
	
	@PostMapping("/")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
		Restaurant addedRestaurant = restraService.addRestaurant(restaurant);
		
		return new ResponseEntity<Restaurant>(addedRestaurant, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable int restaurantId){
		Restaurant fetchedRestaurant = restraService.getRestaurant(restaurantId);
		
		return new ResponseEntity<Restaurant>(fetchedRestaurant, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<Restaurant> updateRestaurantDetails(@PathVariable int customerId, @RequestBody Restaurant restaurant){
		Restaurant updatedRestaurant = restraService.updateRestaurantDetails(customerId, restaurant);
		
		return new ResponseEntity<Restaurant>(updatedRestaurant, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{restaurantId}")
	public ResponseEntity<Restaurant> deleteRestaurant(int restaurantId){
		Restaurant deletedRestaurant = restraService.deleteRestaurant(restaurantId);
		
		return new ResponseEntity<Restaurant>(deletedRestaurant, HttpStatus.OK);
	}
	
	
	@GetMapping("/byParam/")
	public ResponseEntity<Restaurant> restaurantByNameAndAddress(@RequestParam String name, @RequestParam String address){
		Restaurant restaurant = restraService.restaurantByRestaurantNameAndAddress(name, address);
		
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}
}
