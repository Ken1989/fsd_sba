package cn.ibm.com.module;

import lombok.Data;

@Data
public class Payment {
	
	private Integer id;
	private Integer courseId;
	private String userName;
	private String mentorName;
	private Float cost;
}