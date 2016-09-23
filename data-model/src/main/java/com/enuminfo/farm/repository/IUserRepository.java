/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.User;

/**
 * @author Kumar
 */
public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {

	User findByUsername(String username);
}
