/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.User;

/**
 * @author Kumar
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}
