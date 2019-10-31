package cn.ibm.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ibm.com.dao.entity.SbaUser;
import cn.ibm.com.dao.jpa.SbaUserRepository;
import cn.ibm.com.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private SbaUserRepository sbaUserRepository;

	@Override
	public SbaUser saveSbaUser(SbaUser sbaUser) {
		return this.sbaUserRepository.save(sbaUser);
	}

}
