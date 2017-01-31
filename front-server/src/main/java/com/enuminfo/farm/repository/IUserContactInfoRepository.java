package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserContactInfo;

public interface IUserContactInfoRepository extends PagingAndSortingRepository<UserContactInfo, Integer>{

}
