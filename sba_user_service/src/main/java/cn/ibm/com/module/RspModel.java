package cn.ibm.com.module;

import lombok.Data;

@Data
public class RspModel {

	private Integer code;
	private String message;
	private Object data;

}
