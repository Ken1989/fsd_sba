package cn.ibm.com.module;

import java.sql.Date;

import lombok.Data;
@Data
public class MentorCourse {
	
	private Integer id;
	private String name;
	private String mentorName;
	private String skill;
	private Date startDate;
	private Date endDate;
	private Float fee;
	private Integer rate;
	private String description;
	
	

}
