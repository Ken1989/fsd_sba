package cn.ibm.com.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Rate {

	@Id
	private Integer id;
	private Integer cuorseId;
	private Integer rating;


}
