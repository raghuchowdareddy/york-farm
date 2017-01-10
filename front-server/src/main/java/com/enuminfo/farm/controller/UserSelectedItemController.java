package com.enuminfo.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.model.UserSelectedItem;
import com.enuminfo.farm.service.IUserSelectedItem;

@RestController
public class UserSelectedItemController {

	@RequestMapping(value="/draftSelectedItems",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void draftSelectedItem(@RequestBody UserSelectedItem[] userSelectedItem){
		for (UserSelectedItem userSelectedItem2 : userSelectedItem) {
			System.out.println("UserSelectedItemController.draftSelectedItem():: "+userSelectedItem2.toString());
			selectedItem.add(userSelectedItem2);
		}
		
	}
	@Autowired IUserSelectedItem selectedItem;
}
