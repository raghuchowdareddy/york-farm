package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.model.UserSelectItem;

public interface IUserSelectedItem {
  void add(UserSelectItem userSelectedItem);
  List<UserSelectItem> getDraftedItems(Long userNumber);
  void deleteSelectedItem(UserSelectItem userSelectedItem);
  
}
