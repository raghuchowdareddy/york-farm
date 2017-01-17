package com.enuminfo.farm.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserSelectedItem;

public interface IUserSelectedItemRepository extends PagingAndSortingRepository<UserSelectedItem, Integer>{
	//@NamedQuery(query="select * from UserSelectedItem usi where usi.userMobileNo=:userNumber and usi.isDrafted=:drafted")
	List<UserSelectedItem> findByUserMobileNoAndStatus(Long userNumber, String string);
  
}
