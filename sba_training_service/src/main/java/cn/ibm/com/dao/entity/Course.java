package cn.ibm.com.dao.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Course {
	
	@Id
	private Integer id;
	private String name;
	private String description;
	private String skill;
	private Date startDate;
	private Date endDate;
	private String mentorName;
	private Float fee;
	private String status;
	private Integer progress;
	private String userName;
	
	
	

}
