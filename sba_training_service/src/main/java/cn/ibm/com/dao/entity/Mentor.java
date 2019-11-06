package cn.ibm.com.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Mentor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String sex;
	private String idno;
	private boolean status;
	private String birthdate;
	private String password;
	private String jwtstr;
	private String createdby;
	private Date createdate;;
	private String modifiedby;
	private Date modifieddate;
	private String role;

}
