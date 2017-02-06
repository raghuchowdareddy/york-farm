package com.enuminfo.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.model.UserSelectItem;
import com.enuminfo.farm.repository.IUserOrderRepository;
import com.enuminfo.farm.repository.IUserSelectItemRepository;
import com.enuminfo.farm.service.IUserOrder;

@Service
public class UserOrderService implements IUserOrder {
	
	@Override
	public void add(UserOrder userOrder) {
		UserOrder order = null;
		if(null == userOrder.getUserOrderId()){
	 	  order = userOrderRepository.save(new UserOrder());
	 	  userOrder.setUserOrderId(order.getUserOrderId());
		}
		userOrderRepository.save(userOrder);
		List<UserSelectItem> items = userOrder.getItems();
		items.parallelStream().forEach(item->{
			item.setUserOrder(userOrder);
		});
		itemRepository.save(items);
		
	}
	@Override
	public Iterable<UserOrder> findAll() {
		return userOrderRepository.findAll();
	}
	@Override
	public Iterable<UserOrder> findByUserName(String userName) {
		return userOrderRepository.findByUserName(userName);
	}
	@Override
	public UserOrder findById(Integer id) {
		return userOrderRepository.findByUserOrderId(id);
	}
	@Autowired IUserOrderRepository userOrderRepository;
	@Autowired IUserSelectItemRepository itemRepository;
	
}
