package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.DeliveryPartner;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryPartner, Integer>{

}
