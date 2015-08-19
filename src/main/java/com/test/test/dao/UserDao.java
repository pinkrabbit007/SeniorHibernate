/**
 * 
 */
package com.test.test.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.test.domain.LicencePlate;
import com.test.test.domain.User;

/**
 * @author zjq
 * 
 */

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	public User findOneByUsername(String username); 
	//public List<LicencePlate> findByUsername(String username);
}
