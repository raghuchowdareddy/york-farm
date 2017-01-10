package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.enuminfo.farm.model.UserSelectedItem;

public interface IUserSelectedItemRepository extends PagingAndSortingRepository<UserSelectedItem, Integer>{
  
}
