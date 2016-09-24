/**
 * 
 */
package com.enuminfo.farm.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.data.Constants;
import com.enuminfo.farm.path.RequestPath;

/**
 * @author Kumar
 */
@RestController
@RequestMapping(value = RequestPath.SYSTEM)
public class SystemController {

	@RequestMapping(value = RequestPath.PRIVILAGE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String handleInternalRequestForUserSystemName() {
		return System.getProperty(Constants.USER_NAME);
	}
	
	@RequestMapping(value = RequestPath.ADMINS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> handleInternalRequestForAdmins() {
		return Arrays.asList(Constants.ADMINISTRATORS);
	}
}
