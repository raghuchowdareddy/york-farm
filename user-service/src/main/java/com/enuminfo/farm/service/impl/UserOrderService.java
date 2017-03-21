/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.UserOrderDTO;
import com.enuminfo.farm.dto.UserOrderedItemDTO;
import com.enuminfo.farm.model.DeliveryLocation;
import com.enuminfo.farm.model.Product;
import com.enuminfo.farm.model.User;
import com.enuminfo.farm.model.UserDetail;
import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.model.UserOrderDeliveryLocation;
import com.enuminfo.farm.model.UserOrderedItem;
import com.enuminfo.farm.repository.IDeliveryLocationRepository;
import com.enuminfo.farm.repository.IProductRepository;
import com.enuminfo.farm.repository.IUserDetailRepository;
import com.enuminfo.farm.repository.IUserOrderDeliveryLocationRepository;
import com.enuminfo.farm.repository.IUserOrderRepository;
import com.enuminfo.farm.repository.IUserOrderedItemRepository;
import com.enuminfo.farm.repository.IUserRepository;
import com.enuminfo.farm.service.IUserOrderService;
import com.enuminfo.farm.util.DateTimeUtil;
import com.google.common.collect.Lists;

/**
 * @author Kumar
 */
@Service
public class UserOrderService implements IUserOrderService {

	@Autowired IUserRepository userRepository;
	@Autowired IUserOrderRepository userOrderRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	@Autowired IProductRepository productRepository;
	@Autowired IUserDetailRepository userDetailRepository;
	@Autowired IDeliveryLocationRepository deliveryLocationRepository;
	@Autowired IUserOrderDeliveryLocationRepository userOrderDeliveryLocationRepository;
	
	@Override
	public void addDraftedUserOrder(UserOrderDTO dtoUserOrder) {
		UserDetail detailUser = userDetailRepository.findOne(dtoUserOrder.getUserId());
		UserOrder userOrder = UserOrder.getBuilder()
				.withUser(detailUser)
				.withStatus(dtoUserOrder.getStatus())
				.withCreatedDate(new Timestamp(new Date().getTime()))
				.build();
		UserOrder savedUserOrder = userOrderRepository.save(userOrder);
		for (Iterator<UserOrderedItemDTO> iterator = dtoUserOrder.getOrderedItems().iterator(); iterator.hasNext();) {
			UserOrderedItemDTO dtoUserorderedItem = iterator.next();
			UserOrderedItem userOrderedItem = UserOrderedItem.getBuilder()
					.withUserOrder(savedUserOrder)
					.withProduct(productRepository.findOne(dtoUserorderedItem.getProductId()))
					.withQuantity(dtoUserorderedItem.getQuantity())
					.withPrice(dtoUserorderedItem.getPrice())
					.build();
			userOrderedItemRepository.save(userOrderedItem);
		}
	}
	
	@Override
	public List<UserOrderDTO> loadAllUserOrders(String status) {
		List<UserOrderDTO> dtoUserOrders = new ArrayList<UserOrderDTO>();
		
		return dtoUserOrders;
	}
	
	@Override
	public UserOrderDTO loadUserOrder(String username, String status) {
		UserOrderDTO dtoUserOrder = new UserOrderDTO();
		User user = userRepository.findByUsername(username);
		UserDetail userDetail = userDetailRepository.findOne(user.getId());
		UserOrder userOrder = userOrderRepository.findByUserAndStatus(userDetail, status);
		if (userOrder != null) {
			dtoUserOrder = convert2DTO(userOrder);
			Iterable<UserOrderedItem> orderedItems = userOrderedItemRepository.findByUserOrder(userOrder);
			List<UserOrderedItemDTO> dtoUserOrderedItems = new ArrayList<UserOrderedItemDTO>();
			for (Iterator<UserOrderedItem> iterator = orderedItems.iterator(); iterator.hasNext();) {
				UserOrderedItem orderedItem = iterator.next();
				dtoUserOrderedItems.add(convert2DTO(orderedItem));
			}
			dtoUserOrder.setOrderedItems(dtoUserOrderedItems);
		}
		return dtoUserOrder;
	}
	
	private UserOrderDTO convert2DTO(UserOrder userOrder) {
		UserOrderDTO dtoUserOrder = new UserOrderDTO();
		dtoUserOrder.setOrderId(userOrder.getId());
		dtoUserOrder.setUserName(userOrder.getUser().getName());
		dtoUserOrder.setMobileNumber(userOrder.getUser().getMobileNumber());
		dtoUserOrder.setEmailAddress(userOrder.getUser().getEmailAddress());
		dtoUserOrder.setStatus(userOrder.getStatus());
		dtoUserOrder.setCreatedDate(userOrder.getCreatedDate());
		dtoUserOrder.setUpdatedDate(userOrder.getUpdatedDate());
		dtoUserOrder.setDeliveryDate(userOrder.getDeliveryDate());
		return dtoUserOrder;
	}
	
	private UserOrderedItemDTO convert2DTO(UserOrderedItem userOrderedItem) {
		UserOrderedItemDTO dtoUserOrderedItem = new UserOrderedItemDTO();
		dtoUserOrderedItem.setProductId(userOrderedItem.getProduct().getId());
		dtoUserOrderedItem.setProductName(userOrderedItem.getProduct().getName());
		dtoUserOrderedItem.setQuantity(userOrderedItem.getQuantity());
		dtoUserOrderedItem.setPrice(userOrderedItem.getPrice());
		return dtoUserOrderedItem;
	}

	@Override
	public void editDraftedUserOrder(UserOrderDTO dtoUserOrder) {
		UserDetail detailUser = userDetailRepository.findOne(dtoUserOrder.getUserId());
		UserOrder userOrder = UserOrder.getBuilder()
				.withId(dtoUserOrder.getOrderId())
				.withUser(detailUser)
				.withStatus(dtoUserOrder.getStatus())
				.withCreatedDate(DateTimeUtil.convertUtilDate2Timestamp(dtoUserOrder.getCreatedDate()))
				.withUpdatedDate(new Timestamp(new Date().getTime()))
				.build();
		List<UserOrderedItem> orderedItemsFromDB = Lists.newArrayList(userOrderedItemRepository.findByUserOrder(userOrder));
		List<UserOrderedItem> orderedItemsFromScreen = new ArrayList<UserOrderedItem>();		
		UserOrder savedUserOrder = userOrderRepository.save(userOrder);		
		for (Iterator<UserOrderedItemDTO> iterator = dtoUserOrder.getOrderedItems().iterator(); iterator.hasNext();) {
			UserOrderedItemDTO dtoUserorderedItem = iterator.next();
			UserOrderedItem userOrderedItem = UserOrderedItem.getBuilder()
					.withId(dtoUserorderedItem.getUserOrderItemId())
					.withUserOrder(savedUserOrder)
					.withProduct(productRepository.findOne(dtoUserorderedItem.getProductId()))
					.withQuantity(dtoUserorderedItem.getQuantity())
					.withPrice(dtoUserorderedItem.getPrice())
					.build();
			orderedItemsFromScreen.add(userOrderedItem);
		}
		for (Iterator<UserOrderedItem> iteratorFromScreen = orderedItemsFromScreen.iterator(); iteratorFromScreen.hasNext();) {
			UserOrderedItem orderedItemFromScreen = iteratorFromScreen.next();
			if (orderedItemFromScreen.getId() == 0)
				userOrderedItemRepository.save(orderedItemFromScreen);
		}
		for (Iterator<UserOrderedItem> iteratorFromScreen = orderedItemsFromDB.iterator(); iteratorFromScreen.hasNext();) {
			UserOrderedItem orderedItemFromDB = iteratorFromScreen.next();
			if (!orderedItemsFromScreen.contains(orderedItemFromDB))
				userOrderedItemRepository.delete(orderedItemFromDB);
		}
		for (Iterator<UserOrderedItem> iteratorFromScreen = orderedItemsFromScreen.iterator(); iteratorFromScreen.hasNext();) {
			UserOrderedItem orderedItemFromScreen = iteratorFromScreen.next();
			if (orderedItemsFromDB.contains(orderedItemFromScreen))
				userOrderedItemRepository.save(orderedItemFromScreen);
		}
	}

	@Override
	public void confirmedUserOrder(UserOrderDTO dtoUserOrder) {
		UserDetail detailUser = userDetailRepository.findOne(dtoUserOrder.getUserId());
		UserOrder userOrder = UserOrder.getBuilder()
				.withId(dtoUserOrder.getOrderId())
				.withUser(detailUser)
				.withStatus(dtoUserOrder.getStatus())
				.withCreatedDate(DateTimeUtil.convertUtilDate2Timestamp(dtoUserOrder.getCreatedDate()))
				.withUpdatedDate(new Timestamp(new Date().getTime()))
				.build();
		UserOrder savedUserOrder = userOrderRepository.save(userOrder);
		DeliveryLocation deliveryLocation = deliveryLocationRepository.findOne(dtoUserOrder.getDeliveryLocationId());
		UserOrderDeliveryLocation orderDeliveryLocation = UserOrderDeliveryLocation.getBuilder()
				.withUserOrder(savedUserOrder)
				.withDeliveryLocation(deliveryLocation)
				.build();
		userOrderDeliveryLocationRepository.save(orderDeliveryLocation);
	}

	@Override
	public List<UserOrderedItemDTO> loadAllUserOrderedItemsByProduct(int productId) {
		List<UserOrderedItemDTO> dtoUserOrderedItems = new ArrayList<UserOrderedItemDTO>();
		Product product = productRepository.findOne(productId);
		Iterable<UserOrderedItem> orderedItems = userOrderedItemRepository.findByProduct(product);
		for (Iterator<UserOrderedItem> iterator = orderedItems.iterator(); iterator.hasNext();) {
			UserOrderedItem orderedItem = iterator.next();
			dtoUserOrderedItems.add(convert2DTO(orderedItem));
		}
		return dtoUserOrderedItems;
	}
}
