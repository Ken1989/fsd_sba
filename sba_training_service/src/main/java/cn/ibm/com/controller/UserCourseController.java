package cn.ibm.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ibm.com.dao.entity.UserCourse;
import cn.ibm.com.dao.jpa.UserCourseRepository;
import cn.ibm.com.module.RspModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/training")
public class UserCourseController {
	
	@Autowired
	private UserCourseRepository userCourseRepository;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "SBA User Course List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"), @ApiResponse(code = 403, message = "No Permission"),
			@ApiResponse(code = 404, message = "No Mentors Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<RspModel> finUserCourses(@ApiParam(name = "username", required = true) @RequestParam String username,
			@ApiParam(name = "progress", required = true) @RequestParam Integer progress) {

		try {

			List<UserCourse> usercourses = userCourseRepository.findByName(username);
		
			if (usercourses.size() > 0) {
				
				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Found Courses");
				rsp.setData(usercourses);
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
				
			} else {
				RspModel rsp = new RspModel();
				rsp.setCode(404);
				rsp.setMessage("No Found Courses");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
			}


		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
