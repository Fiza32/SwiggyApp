package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Orders;



@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
//	Orders findByCustomer_CustomerId(int customerId);
	Orders findByCustomer_CustomerId(int customerId);
}
