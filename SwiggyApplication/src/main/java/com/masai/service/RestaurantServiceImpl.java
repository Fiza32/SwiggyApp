package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.RestaurantException;
import com.masai.model.Restaurant;
import com.masai.repository.RestaurantRepository;


@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
		if(restaurant == null) {
			throw new RestaurantException("You've provided null value, Please provide valid data");
		}
		
		if(restaurantRepo.findById(restaurant.getRestaurantId()).isPresent()) {
			throw new RestaurantException("Restaurant already exists with the same Id: " + restaurant.getRestaurantId());
		}
		
		Restaurant savedRestaurant = restaurantRepo.save(restaurant);
		
		return savedRestaurant;
	}

	
	@Override
	public Restaurant getRestaurant(int restaurantId) throws RestaurantException {
		// TODO Auto-generated method stub
		Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow(() -> new RestaurantException("Restaurant not found with id " + restaurantId));
		
		return restaurant;
	}

	@Override
	public Restaurant updateRestaurantDetails(int customerId, Restaurant restaurant) throws RestaurantException {
		Restaurant fetchedRestaurant = restaurantRepo.findById(customerId).orElseThrow(() -> new RestaurantException("Restaurant not found with id " + restaurant.getRestaurantId()));
		
		restaurant.setRestaurantId(customerId);
		
		Restaurant updatedRestaurant = restaurantRepo.save(fetchedRestaurant);
		return updatedRestaurant;
	}

	@Override
	public Restaurant deleteRestaurant(int restaurantId) throws RestaurantException {
		Restaurant fetchedRestaurant = restaurantRepo.findById(restaurantId).orElseThrow(() -> new RestaurantException("Restaurant not found with id " + restaurantId));
		
		restaurantRepo.delete(fetchedRestaurant);
		
		return fetchedRestaurant;
	}

	@Override
	public Restaurant restaurantByRestaurantNameAndAddress(String name, String address) throws RestaurantException {
		Restaurant restaurant = restaurantRepo.findByRestaurantNameAndAddress(name, address).orElseThrow(() -> new RestaurantException ("Restaurant not found with provided name: " + name + " and address: " + address));
		
		return restaurant;
	}

//
//	public Restaurant restaurantByNameAndAddress(String string, String string2) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
