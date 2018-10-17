package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

//투두 리스트에서 List<OrderVO> 불가해서 꼼수
@Data
public class OrderList {
	
	private List<OrderVO> list;

	public OrderList() {
		list = new ArrayList<>();
	}
	
	

}
