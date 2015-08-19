/**
 * 
 */
package com.test.test.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.test.domain.User;

/**
 * @author zjq
 * 
 */

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	public User findOneByUsername(String userName); 
}
