package com.enuminfo.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.model.UserSelectItem;
import com.enuminfo.farm.repository.IUserSelectItemRepository;
import com.enuminfo.farm.service.IUserSelectItem;

@Service
public class UserSelectItemService implements IUserSelectItem {
	
	@Override
	public void add(UserSelectItem userSelectedItem) {
	  selectedItemRepository.save(userSelectedItem);

	}
	@Override
	public List<UserSelectItem>  getDraftedItems(Long userNumber) {
	  return selectedItemRepository.findByUserMobileNoAndStatus(userNumber,"drafted");
	}
	@Override
	public void deleteSelectedItem(UserSelectItem userSelectedItem) {
		if(userSelectedItem.getUserSelectItemId()!=0){
			if(selectedItemRepository.findOne(userSelectedItem.getUserSelectItemId())!=null){
				selectedItemRepository.delete(userSelectedItem.getUserSelectItemId());
			}
		}
	}
	
	@Autowired IUserSelectItemRepository selectedItemRepository;
	
}