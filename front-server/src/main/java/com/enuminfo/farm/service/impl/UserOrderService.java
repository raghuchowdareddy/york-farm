package com.enuminfo.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.model.UserContactInfo;
import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.model.UserSelectItem;
import com.enuminfo.farm.repository.IUserContactInfoRepository;
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
		//re-check delivery contact information if it is same or changed
		UserContactInfo _this = userOrder.getUserContactInfo();;
		if(null != _this.getUserContactInfo()){
			UserContactInfo _that = contactInfoRepository.findOne(_this.getUserContactInfo());
			if(!_that.equals(_this)){
				_this.setUserContactInfo(null);
			}
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
		return userOrderRepository.findByUserNameOrderByOrderDateDesc(userName);
	}
	@Override
	public UserOrder findById(Integer id) {
		return userOrderRepository.findByUserOrderId(id);
	}
	@Override
	public void delete(Integer id) {
		userOrderRepository.delete(id);
	}
	@Autowired IUserOrderRepository userOrderRepository;
	@Autowired IUserSelectItemRepository itemRepository;
	@Autowired IUserContactInfoRepository contactInfoRepository;
	
}
