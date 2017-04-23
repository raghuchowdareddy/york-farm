/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserDetail;

/**
 * @author Kumar
 */
public interface IUserDetailRepository extends PagingAndSortingRepository<UserDetail, Integer> {

}
