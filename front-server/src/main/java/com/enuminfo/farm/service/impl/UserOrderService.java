package com.enuminfo.farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.repository.IUserOrderRepository;
import com.enuminfo.farm.service.IUserOrder;

@Service
public class UserOrderService implements IUserOrder {
	
	@Override
	public void add(UserOrder userOrder) {
		userOrderRepository.save(userOrder);
	}
	@Override
	public Iterable<UserOrder> findAll() {
		return userOrderRepository.findAll();
	}
	@Override
	public UserOrder findById(Integer id) {
		return userOrderRepository.findByUserOrderId(id);
	}
	@Autowired IUserOrderRepository userOrderRepository;
	
}
