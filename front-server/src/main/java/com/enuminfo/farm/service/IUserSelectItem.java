package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.model.UserSelectItem;

public interface IUserSelectItem {
  void add(UserSelectItem userSelectedItem);
  List<UserSelectItem> getDraftedItems(Long userNumber);
  void deleteSelectedItem(UserSelectItem userSelectedItem);
  
}
