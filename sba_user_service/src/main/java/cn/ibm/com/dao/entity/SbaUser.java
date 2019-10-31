package cn.ibm.com.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@Entity
@Table(name="SBA_USER")
public class SbaUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String sex;
	private String idno;
	private String status;
	private String birthdate;
	private String password;
	private String jwtstr;
	private String createdby;
	private Date createdate;;
	private String modifiedby;
	private Date modifieddate;

}
