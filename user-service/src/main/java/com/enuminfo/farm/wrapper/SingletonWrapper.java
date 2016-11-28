/**
 * 
 */
package com.enuminfo.farm.wrapper;

/**
 * @author Kumar
 */
class SingletonWrapper {

	static final UserWrapper USER_WRAPPER_INSTANCE = new UserWrapper();
	static final RoleWrapper ROLE_WRAPPER_INSTANCE = new RoleWrapper();
	static final CustomerWrapper CUSTOMER_WRAPPER_INSTANCE = new CustomerWrapper();
	static final AddressWrapper ADDRESS_WRAPPER_INSTANCE = new AddressWrapper();
	static final CountryWrapper COUNTRY_WRAPPER_INSTANCE = new CountryWrapper();
	static final LocationWrapper LOCATION_WRAPPER_INSTANCE = new LocationWrapper();
}
