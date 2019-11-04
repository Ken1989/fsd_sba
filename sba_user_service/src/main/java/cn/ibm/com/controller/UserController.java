package cn.ibm.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.ibm.com.dao.entity.SbaUser;
import cn.ibm.com.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public SbaUser saveUser(@RequestBody SbaUser user) {
		log.info("--> Save user " + user);
		return this.userService.saveSbaUser(user);
	}

	
	@GetMapping
	public List<SbaUser> findAllUsers(){
		return this.userService.findallUser();
		
	}
	
	
	@PutMapping
	public List<SbaUser> findAllUsersTest(){
		return this.userService.findallUser();
	}
}
