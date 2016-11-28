/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Customer;

/**
 * @author Kumar
 */
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

}
