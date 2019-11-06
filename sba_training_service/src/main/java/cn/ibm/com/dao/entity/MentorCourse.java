package cn.ibm.com.dao.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MentorCourse {
	
	@Id
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
