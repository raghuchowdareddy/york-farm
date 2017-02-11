package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserOrder;

public interface IUserOrderRepository extends PagingAndSortingRepository<UserOrder, Integer>{

	UserOrder findByUserOrderId(Integer id);
	Iterable<UserOrder> findByUserNameOrderByOrderDateDesc(String userName);

}
