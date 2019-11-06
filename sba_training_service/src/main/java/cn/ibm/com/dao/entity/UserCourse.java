package cn.ibm.com.dao.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class UserCourse {
	
	private Integer id;
	private String skill;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private String mentorName;
	private String progress;
	
	

}
