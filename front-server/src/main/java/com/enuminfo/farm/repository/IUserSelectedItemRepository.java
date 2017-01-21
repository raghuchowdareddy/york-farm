package com.enuminfo.farm.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserSelectItem;

public interface IUserSelectedItemRepository extends PagingAndSortingRepository<UserSelectItem, Integer>{
	//@NamedQuery(query="select * from UserSelectedItem usi where usi.userMobileNo=:userNumber and usi.isDrafted=:drafted")
	List<UserSelectItem> findByUserMobileNoAndStatus(Long userNumber, String string);
  
}
