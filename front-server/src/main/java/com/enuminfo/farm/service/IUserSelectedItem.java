package com.enuminfo.farm.service;

import com.enuminfo.farm.model.UserSelectedItem;

public interface IUserSelectedItem {
  void add(UserSelectedItem userSelectedItem);

  UserSelectedItem[] getDraftedItems(Integer userNumber);
  
}
