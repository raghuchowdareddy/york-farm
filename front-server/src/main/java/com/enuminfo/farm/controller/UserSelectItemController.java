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
import com.enuminfo.farm.service.IUserSelectItem;

@RestController
public class UserSelectItemController {

	@RequestMapping(value="/draftSelectedItems",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void draftSelectedItem(@RequestBody UserSelectItem[] userSelectedItem){
		for (UserSelectItem userSelectedItem2 : userSelectedItem) {
			selectedItem.add(userSelectedItem2);
		}
		
	}
	@RequestMapping(value="/getDraftedItems/{userNumber}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserSelectItem> getDraftedItems(@PathVariable String userNumber){
		  return selectedItem.getDraftedItems(Long.valueOf(userNumber));
			
	}
	@RequestMapping(value="/deleteItem",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteItem(@RequestBody UserSelectItem userSelectedItem){
		   selectedItem.deleteSelectedItem(userSelectedItem);
	}
	@Autowired IUserSelectItem selectedItem;
}
