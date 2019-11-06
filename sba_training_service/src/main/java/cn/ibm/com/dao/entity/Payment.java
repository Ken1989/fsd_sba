package cn.ibm.com.dao.entity;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Payment {
	
	@Id
	private Integer id;
	private Integer courseId;
	private String userName;
	private String mentorName;
	private Float cost;
	
}