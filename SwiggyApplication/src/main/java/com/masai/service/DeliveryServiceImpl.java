package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DeliveryException;
import com.masai.model.DeliveryPartner;
import com.masai.repository.DeliveryRepository;



@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepo;
	
	@Override
	public DeliveryPartner addDeliveryPartner(DeliveryPartner deliveryPartner) throws DeliveryException {
		if(deliveryPartner == null) {
			throw new DeliveryException("Please provide valid data");
		}
		
		if(deliveryRepo.findById(deliveryPartner.getDeliveryId()).isPresent()){
			throw new DeliveryException("Delivery Partner with id " + deliveryPartner.getDeliveryId() + " already exists");
		}
		
		DeliveryPartner savedDeliveryPartner = deliveryRepo.save(deliveryPartner);
		
		return savedDeliveryPartner;
	}

	
	@Override
	public DeliveryPartner getDeliveryPartner(int deliveryPartnerId) throws DeliveryException {
		DeliveryPartner deliveryPartner = deliveryRepo.findById(deliveryPartnerId).orElseThrow(() -> new DeliveryException("Delivery Partner not found with id " + deliveryPartnerId));
		
		return deliveryPartner;
	}

	@Override
	public DeliveryPartner updateDeliveryPartner(int deliveryPartnerId, DeliveryPartner deliveryPartner) throws DeliveryException {
		DeliveryPartner receivedDeliveryPartner = deliveryRepo.findById(deliveryPartnerId).orElseThrow(() -> new DeliveryException("Delivery Partner not found with id " + deliveryPartnerId));
		
		receivedDeliveryPartner.setDeliveryName(deliveryPartner.getDeliveryName());
		receivedDeliveryPartner.setAddress(deliveryPartner.getAddress());
		receivedDeliveryPartner.setOrders(deliveryPartner.getOrders());
		receivedDeliveryPartner.setRestaurant(deliveryPartner.getRestaurant());
		
		DeliveryPartner updatedDeliveryPartner = deliveryRepo.save(receivedDeliveryPartner);
		return updatedDeliveryPartner;
	}

	@Override
	public DeliveryPartner deleteDeliveryPartner(int deliveryPartnerId) throws DeliveryException {
		DeliveryPartner receivedDeliveryPartner = deliveryRepo.findById(deliveryPartnerId).orElseThrow(() -> new DeliveryException("Delivery Partner not found with id " + deliveryPartnerId));
		
		deliveryRepo.delete(receivedDeliveryPartner);
		
		return receivedDeliveryPartner;
	}

}
