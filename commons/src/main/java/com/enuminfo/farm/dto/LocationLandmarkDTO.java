/**
 * 
 */
package com.enuminfo.farm.dto;

import java.io.Serializable;



/**
 * @author Kumar
 */
public class LocationLandmarkDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer locationLandmarkid;
	private String name;
	private LocationDTO locationDTO;

	public LocationLandmarkDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getLocationLandmarkid() {
		return locationLandmarkid;
	}

	public void setLocationLandmarkid(Integer locationLandmarkid) {
		this.locationLandmarkid = locationLandmarkid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	
}
