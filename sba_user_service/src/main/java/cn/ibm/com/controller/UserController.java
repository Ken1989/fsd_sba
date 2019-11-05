package cn.ibm.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ibm.com.dao.entity.SbaUser;
import cn.ibm.com.module.RspModel;
import cn.ibm.com.service.UserService;
import cn.ibm.com.util.EncrytedPasswordUtils;
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
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RspModel> addUser(@RequestBody SbaUser user) {

		try {
			SbaUser sbaUser = this.userService.findUserByName(user.getName());
			if (sbaUser != null) {
				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Account Created");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
			} else {
				SbaUser newuser = new SbaUser();
				String encrytedpassword = EncrytedPasswordUtils.encrytePassword(user.getPassword());
				newuser.setPassword(encrytedpassword);
				newuser.setName(user.getName());
				newuser.setName(user.getName());
				newuser.setRole(user.getRole());
				if (user.getRole().equals("user")) {
					newuser.setStatus(true);
				}else {
					newuser.setStatus(false);
				}
				this.userService.saveSbaUser(newuser);

				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Account Created");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RspModel> queryUser(@RequestParam String username) {

		try {
			SbaUser user =this.userService.findUserByName(username);
			if (user != null) {
				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Ok");
				rsp.setData(user);
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);	
				
			} else {
				RspModel rsp = new RspModel();
				rsp.setCode(404);
				rsp.setMessage("Account No Found");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.NOT_FOUND);		
			}
			

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
