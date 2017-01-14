package com.enuminfo.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.model.UserSelectedItem;
import com.enuminfo.farm.service.IUserSelectedItem;

@RestController
public class UserSelectedItemController {

	@RequestMapping(value="/draftSelectedItems",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void draftSelectedItem(@RequestBody List<UserSelectedItem> userSelectedItems){
		for (UserSelectedItem userSelectedItem : userSelectedItems) {
			System.out.println("UserSelectedItemController.draftSelectedItem():: "+userSelectedItem.toString());
			selectedItem.add(userSelectedItem);
		}
		
	}
	@RequestMapping(value="/getDraftedItems/{userNumber}",method = RequestMethod.GET,
			consumes=MediaType.TEXT_HTML_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public UserSelectedItem[] getDraftedItems(@PathVariable String userNumber){
		  return selectedItem.getDraftedItems(Integer.valueOf(userNumber));
			
	}
	
	@Autowired IUserSelectedItem selectedItem;
}
