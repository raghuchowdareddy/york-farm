package com.enuminfo.farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.model.UserSelectedItem;
import com.enuminfo.farm.repository.IUserSelectedItemRepository;
import com.enuminfo.farm.service.IUserSelectedItem;

@Service
public class UserSelectedItemService implements IUserSelectedItem {
	
	@Override
	public void add(UserSelectedItem userSelectedItem) {
	  selectedItemRepository.save(userSelectedItem);

	}
	@Override
	public UserSelectedItem[] getDraftedItems(Integer userNumber) {
	  return selectedItemRepository.findByUserMobileNoAndDraftedTrue(userNumber,true);
	}
	
	@Autowired IUserSelectedItemRepository selectedItemRepository;
	
}
