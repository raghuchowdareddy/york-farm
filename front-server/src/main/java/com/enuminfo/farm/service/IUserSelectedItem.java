package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.model.UserSelectedItem;

public interface IUserSelectedItem {
  void add(UserSelectedItem userSelectedItem);
  List<UserSelectedItem> getDraftedItems(Long userNumber);
  
}
