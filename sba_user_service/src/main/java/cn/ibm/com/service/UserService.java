package cn.ibm.com.service;

import cn.ibm.com.dao.entity.SbaUser;

public interface UserService {

	/**
	 * Add a new User
	 * @param sbaUser
	 * @return
	 */
	public SbaUser saveSbaUser(SbaUser sbaUser);
}
