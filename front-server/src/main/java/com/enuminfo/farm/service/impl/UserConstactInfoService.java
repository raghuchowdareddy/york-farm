package com.enuminfo.farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.model.UserContactInfo;
import com.enuminfo.farm.repository.IUserContactInfoRepository;
import com.enuminfo.farm.service.IUserContactInfo;

@Service
public class UserConstactInfoService implements IUserContactInfo {
	
	@Override
	public void add(UserContactInfo contactInfo) {
		userContactInfoRepo.save(contactInfo);
	}
	
	@Autowired IUserContactInfoRepository userContactInfoRepo;
	
}
