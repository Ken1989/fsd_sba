package cn.ibm.com.service;

import java.util.List;

import cn.ibm.com.dao.entity.SbaUser;

public interface UserService {

	/**
	 * Add a new User
	 * @param sbaUser
	 * @return
	 */
	public SbaUser saveSbaUser(SbaUser sbaUser);

	/**
	 * Find all of users data
	 * @return
	 */
	public List<SbaUser> findallUser();
	
	
	/**
	 * Find the user by name
	 * @param name
	 * @return
	 */
	public SbaUser findUserByName(String name);
}
