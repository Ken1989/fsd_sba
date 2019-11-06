package cn.ibm.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ibm.com.dao.entity.Course;
import cn.ibm.com.dao.jpa.CourseRepository;
import cn.ibm.com.module.RspModel;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	

	@RequestMapping(value = "/addcourse", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RspModel> addCourse(@RequestBody Course course) {

		try {

			this.courseRepository.save(course);
			
			RspModel rsp = new RspModel();
			rsp.setCode(200);
			rsp.setMessage("Course Created");
			return new ResponseEntity<RspModel>(rsp, HttpStatus.CREATED);

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}


}
