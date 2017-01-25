/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.LocationDTO;
import com.enuminfo.farm.model.DeliveryLocation;

/**
 * @author Kumar
 */
public class DeliveryLocationWrapper {

	DeliveryLocationWrapper() {

	}
	
	public static DeliveryLocationWrapper getInstance() {
		return SingletonWrapper.DELIVERY_LOCATION_WRAPPER;
	}
	
	public DeliveryLocation convert2ModelWithoutId(LocationDTO dtoLocation) {
		DeliveryLocation deliveryLocation = DeliveryLocation.getBuilder()
				.withStreet(dtoLocation.getValue1())
				.withLandmark1(dtoLocation.getValue2())
				.withLandmark2(dtoLocation.getValue3())
				.withLocation(LocationWrapper.getInstance().convert2ModelWithId(dtoLocation))
				.build();
		return deliveryLocation;
	}
	
	public LocationDTO convert2DTO(DeliveryLocation deliveryLocation) {
		LocationDTO dtoLocation = LocationWrapper.getInstance().convert2DTO(deliveryLocation.getLocation());
		dtoLocation.setValue1(deliveryLocation.getStreet());
		dtoLocation.setValue2(deliveryLocation.getLandmark1());
		dtoLocation.setValue3(deliveryLocation.getLandmark2());
		return dtoLocation;
	}
}
