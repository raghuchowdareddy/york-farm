package com.enuminfo.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.model.UserSelectItem;
import com.enuminfo.farm.service.IUserSelectedItem;

@RestController
public class UserSelectedItemController {

	@RequestMapping(value="/draftSelectedItems",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void draftSelectedItem(@RequestBody UserSelectItem[] UserSelectItem){
		for (UserSelectItem UserSelectItem2 : UserSelectItem) {
			selectedItem.add(UserSelectItem2);
		}
		
	}
	@RequestMapping(value="/getDraftedItems/{userNumber}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserSelectItem> getDraftedItems(@PathVariable String userNumber){
		  return selectedItem.getDraftedItems(Long.valueOf(userNumber));
			
	}
	@Autowired IUserSelectedItem selectedItem;
}

