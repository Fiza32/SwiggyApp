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

import com.masai.model.DeliveryPartner;
import com.masai.service.DeliveryServiceImpl;

@Controller
@RequestMapping("/api/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryServiceImpl deliveryService;
	
	@PostMapping("/")
	public ResponseEntity<DeliveryPartner> addDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner){
		DeliveryPartner addedDeliveryPartner = deliveryService.addDeliveryPartner(deliveryPartner);
		
		return new ResponseEntity<DeliveryPartner>(addedDeliveryPartner, HttpStatus.CREATED);
	}
	
	@GetMapping("/{deliveryPartnerId}")
	public ResponseEntity<DeliveryPartner> getDeliveryPartner(@PathVariable int deliveryPartnerId){
		DeliveryPartner receiveDeliveryPartner = deliveryService.getDeliveryPartner(deliveryPartnerId);
		
		return new ResponseEntity<DeliveryPartner>(receiveDeliveryPartner, HttpStatus.OK);
	}
	
	@PutMapping("/update/{deliveryPartnerId}")
	public ResponseEntity<DeliveryPartner> updateDeliveryPartner(@PathVariable int deliveryPartnerId, @RequestBody DeliveryPartner deliveryPartner){
		DeliveryPartner updatedDeliveryPartner = deliveryService.updateDeliveryPartner(deliveryPartnerId, deliveryPartner);
		
		return new ResponseEntity<DeliveryPartner>(updatedDeliveryPartner, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{deliveryPartnerId}")
	public ResponseEntity<DeliveryPartner> deleteDeliveryPartner(int deliveryPartnerId){
		DeliveryPartner deleteDeliveryPartner = deliveryService.deleteDeliveryPartner(deliveryPartnerId);
		
		return new ResponseEntity<DeliveryPartner>(deleteDeliveryPartner, HttpStatus.OK);
	}
}
