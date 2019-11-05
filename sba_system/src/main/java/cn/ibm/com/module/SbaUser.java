package cn.ibm.com.module;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class SbaUser {
	private Long id;
	private String name;
	private String sex;
	private String idno;
	private String status;
	private String role;
	private String birthdate;
	private String password;
	private String jwtstr;
	private String createdby;
	private Date createdate;;
	private String modifiedby;
	private Date modifieddate;

}
