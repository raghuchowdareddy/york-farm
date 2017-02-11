package com.enuminfo.farm.service;

import com.enuminfo.farm.model.UserOrder;

public interface IUserOrder {
  void add(UserOrder userOrder);
  Iterable<UserOrder> findAll();
  UserOrder findById(Integer id);
  Iterable<UserOrder> findByUserName(String userName);
  void delete(Integer id);
  }
