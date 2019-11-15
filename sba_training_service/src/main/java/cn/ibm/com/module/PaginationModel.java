package cn.ibm.com.module;

import java.util.List;

import lombok.Data;

@Data
public class PaginationModel<T> {

	private List<T> rows;
	private int total;
}
