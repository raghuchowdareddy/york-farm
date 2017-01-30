/**
 * 
 */
package com.enuminfo.farm.wrapper;

/**
 * @author Kumar
 */
public class UserOrderWrapper {

	UserOrderWrapper() {
		
	}
	
	public static UserOrderWrapper getInstance() {
		return SingletonWrapper.USER_ORDER_WRAPPER;
	}
}
