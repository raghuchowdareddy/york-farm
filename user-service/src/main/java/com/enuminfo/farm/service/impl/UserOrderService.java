/**
 * 
 */
package com.enuminfo.farm.service.impl;

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
				.withDraftedDate(new Date())
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
	public List<UserOrderDTO> loadUserOrders(String username, String status) {
		List<UserOrderDTO> dtoUserOrders = new ArrayList<UserOrderDTO>();
		User user = userRepository.findByUsername(username);
		Iterable<UserOrder> userOrders = userOrderRepository.findByUserAndStatus(userDetailRepository.findOne(user.getId()), status);
		for (Iterator<UserOrder> iteratorOrder = userOrders.iterator(); iteratorOrder.hasNext();) {
			UserOrderDTO dtoUserOrder = new UserOrderDTO();
			UserOrder userOrder = iteratorOrder.next();
			dtoUserOrder = convert2DTO(userOrder);
			Iterable<UserOrderedItem> orderedItems = userOrderedItemRepository.findByUserOrder(userOrder);
			List<UserOrderedItemDTO> dtoUserOrderedItems = new ArrayList<UserOrderedItemDTO>();
			for (Iterator<UserOrderedItem> iteratorOrderItem = orderedItems.iterator(); iteratorOrderItem.hasNext();) {
				UserOrderedItem orderedItem = iteratorOrderItem.next();
				dtoUserOrderedItems.add(convert2DTO(orderedItem));
				dtoUserOrder.setQuantity(dtoUserOrder.getQuantity() + orderedItem.getQuantity());
			}
			dtoUserOrder.setOrderedItems(dtoUserOrderedItems);
			dtoUserOrders.add(dtoUserOrder);
			UserOrderDeliveryLocation orderDeliveryLocation = userOrderDeliveryLocationRepository.findByUserOrder(userOrder);
			dtoUserOrder.setDeliveryLocationId(orderDeliveryLocation.getDeliveryLocation().getId());
			dtoUserOrder.setLocationId(orderDeliveryLocation.getDeliveryLocation().getLocation().getId());
			dtoUserOrder.setLocationName(orderDeliveryLocation.getDeliveryLocation().getLocation().getName());
			dtoUserOrder.setLandmark1(orderDeliveryLocation.getDeliveryLocation().getStreet());
			dtoUserOrder.setLandmark2(orderDeliveryLocation.getDeliveryLocation().getLandmark2());
			dtoUserOrder.setLandmark3(orderDeliveryLocation.getDeliveryLocation().getLandmark2());
		}
		return dtoUserOrders;
	}
	
	@Override
	public UserOrderDTO loadUserOrder(String username, String status) {
		UserOrderDTO dtoUserOrder = new UserOrderDTO();
		User user = userRepository.findByUsername(username);
		Iterable<UserOrder> userOrders = userOrderRepository.findByUserAndStatus(userDetailRepository.findOne(user.getId()), status);
		for (Iterator<UserOrder> iteratorOrder = userOrders.iterator(); iteratorOrder.hasNext();) {
			UserOrder userOrder = iteratorOrder.next();
			dtoUserOrder = convert2DTO(userOrder);
			Iterable<UserOrderedItem> orderedItems = userOrderedItemRepository.findByUserOrder(userOrder);
			List<UserOrderedItemDTO> dtoUserOrderedItems = new ArrayList<UserOrderedItemDTO>();
			for (Iterator<UserOrderedItem> iteratorOrderItem = orderedItems.iterator(); iteratorOrderItem.hasNext();) {
				UserOrderedItem orderedItem = iteratorOrderItem.next();
				dtoUserOrderedItems.add(convert2DTO(orderedItem));
				dtoUserOrder.setQuantity(dtoUserOrder.getQuantity() + orderedItem.getQuantity());
			}
			dtoUserOrder.setOrderedItems(dtoUserOrderedItems);
		}
		return dtoUserOrder;
	}
	
	private UserOrderDTO convert2DTO(UserOrder userOrder) {
		UserOrderDTO dtoUserOrder = new UserOrderDTO();
		dtoUserOrder.setOrderId(userOrder.getId());
		dtoUserOrder.setUserId(userOrder.getUser().getId());
		dtoUserOrder.setUserName(userOrder.getUser().getName());
		dtoUserOrder.setMobileNumber(userOrder.getUser().getMobileNumber());
		dtoUserOrder.setEmailAddress(userOrder.getUser().getEmailAddress());
		dtoUserOrder.setStatus(userOrder.getStatus());
		if (userOrder.getDraftedDate() != null) dtoUserOrder.setDraftedDate(userOrder.getDraftedDate().toString());
		if (userOrder.getOrderedDate() != null) dtoUserOrder.setOrderedDate(userOrder.getOrderedDate().toString());
		if (userOrder.getCancelledDate() != null) dtoUserOrder.setCancelledDate(userOrder.getCancelledDate().toString());
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
				.withDraftedDate(DateTimeUtil.convertString2UtilDate(new Date().toString()))
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
				.withDraftedDate(dtoUserOrder.getDraftedDate() != null? DateTimeUtil.convertString2UtilDate(dtoUserOrder.getDraftedDate()) : null)
				.withOrderedDate(new Date())
				.build();
		UserOrder savedUserOrder = userOrderRepository.save(userOrder);
		if (dtoUserOrder.getDraftedDate() == null) {
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

	@Override
	public void cancelledUserOrder(UserOrderDTO dtoUserOrder) {
		UserDetail detailUser = userDetailRepository.findOne(dtoUserOrder.getUserId());
		UserOrder userOrder = UserOrder.getBuilder()
				.withId(dtoUserOrder.getOrderId())
				.withUser(detailUser)
				.withStatus(dtoUserOrder.getStatus())
				.withDraftedDate(dtoUserOrder.getDraftedDate() != null? DateTimeUtil.convertString2UtilDate(dtoUserOrder.getDraftedDate()) : null)
				.withOrderedDate(DateTimeUtil.convertString2UtilDate(dtoUserOrder.getOrderedDate()))
				.withCancelledDate(new Date())
				.build();
		userOrderRepository.save(userOrder);
	}
}
