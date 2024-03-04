package com.masai.service;


import com.masai.exception.DeliveryException;
import com.masai.model.DeliveryPartner;

public interface DeliveryService {

    DeliveryPartner addDeliveryPartner(DeliveryPartner deliveryPartner) throws DeliveryException;
    DeliveryPartner getDeliveryPartner(int deliveryPartnerId) throws DeliveryException;
    DeliveryPartner updateDeliveryPartner(int deliveryPartnerId, DeliveryPartner deliveryPartner) throws DeliveryException;
    DeliveryPartner deleteDeliveryPartner(int deliveryPartnerId) throws DeliveryException;
}
