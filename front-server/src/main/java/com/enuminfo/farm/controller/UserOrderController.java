package com.enuminfo.farm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.service.IUserOrder;

@RestController
public class UserOrderController {

	@RequestMapping(value="/orderItems",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveOrderedItems(@RequestBody UserOrder userOrder){
		System.out.println("UserOrderController.draftSelectedItem()>>"+userOrder.toString());
		userOrderSerive.add(userOrder);
		
	}
	@RequestMapping(value="/fetchOrders",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserOrder> fetchOrders(){
		Iterable<UserOrder> orders = userOrderSerive.findAll();
		List<UserOrder> list = new ArrayList<UserOrder>();
		orders.forEach(order->{list.add(order);});
		return list;
				
	}
	@RequestMapping(value="/fetchOrders/{id}",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public UserOrder fetchOrderById(@PathVariable String id){
		return userOrderSerive.findById(Integer.parseInt(id));
	}

	@Autowired IUserOrder userOrderSerive;
}
