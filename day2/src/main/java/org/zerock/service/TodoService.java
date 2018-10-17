package org.zerock.service;

import java.util.List;

import org.zerock.domain.StoreVO;
import org.zerock.domain.Todo;

public interface TodoService {
	
	public List<Todo> getList();
	
	public List<StoreVO> getStores(String cat);

}
