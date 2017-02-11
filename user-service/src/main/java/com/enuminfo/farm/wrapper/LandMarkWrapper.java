/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.LocationLandmarkDTO;
import com.enuminfo.farm.model.LandMark;

/**
 * @author Kumar
 */
public class LandMarkWrapper {

	LandMarkWrapper() {

	}
	
	public static LandMarkWrapper getInstance() {
		return SingletonWrapper.LANDMARK_WRAPPER_INSTANCE;
	}
	
	public LandMark convert2ModelWithoutId(LocationLandmarkDTO dtoLandMark) {
		LandMark landMark = LandMark.getBuilder()
				.withName(dtoLandMark.getName())
				.withLocation(LocationWrapper.getInstance().convert2ModelWithId(dtoLandMark.getLocationDTO()))
				.build();
		return landMark;
	}
	
	public LandMark convert2ModelWithId(LocationLandmarkDTO dtoLandMark) {
		LandMark landMark = LandMark.getBuilder()
				.withId(dtoLandMark.getLocationLandmarkid())
				.withName(dtoLandMark.getName())
				.withLocation(LocationWrapper.getInstance().convert2ModelWithId(dtoLandMark.getLocationDTO()))
				.build();
		return landMark;
	}
	
	public LocationLandmarkDTO convert2DTO(LandMark landMark) {
		LocationLandmarkDTO landmarkDTO = new LocationLandmarkDTO();
		landmarkDTO.setName(landMark.getName());
		landmarkDTO.setLocationLandmarkid(landMark.getId());
		landmarkDTO.setLocationDTO(LocationWrapper.getInstance().convert2DTO(landMark.getLocation()));
		return landmarkDTO;
	}
}
