package cn.ibm.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ibm.com.dao.entity.MentorCourse;
import cn.ibm.com.dao.entity.Payment;
import cn.ibm.com.dao.jpa.MentorRepository;
import cn.ibm.com.module.RspModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mentor")
public class MentorController {
	
	@Autowired
	private MentorRepository mentorRepository;
	
	@Autowired
	private cn.ibm.com.dao.jpa.MentorCourseRepository mentorCourseRepository;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RspModel> findCourses() {

		try {

			List<MentorCourse> mentorcourses = mentorCourseRepository.findAll();
			
			if (mentorcourses.size() > 0) {
				
				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Found Courses");
				rsp.setData(mentorcourses);
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
	
	@RequestMapping(value = "/searchcourse", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RspModel> searchCourses() {

		try {

			List<MentorCourse> mentorcourses = mentorCourseRepository.findAll();
			
			if (mentorcourses.size() > 0) {
				
				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Found Courses");
				rsp.setData(mentorcourses);
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
	
	@RequestMapping(value = "/book", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "SBA Mentor Course List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"), @ApiResponse(code = 403, message = "No Permission"),
			@ApiResponse(code = 404, message = "No Mentors Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<RspModel> bookCourses(@ApiParam(name = "username", required = true) @RequestParam String username,
			@ApiParam(name = "id", required = true) @RequestParam Integer id,
			@ApiParam(name = "mentorname", required = true) @RequestParam String mentorname) {

		try {
				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Book Sucessful");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
