package org.zerock.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.domain.Todo;
import org.zerock.mapper.TimeMapper;
import org.zerock.mapper.TodoMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests extends AbstractTests {
	
	@Setter(onMethod_=@Autowired)
	private TimeMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private TodoMapper todoMapper;
	
	//TimeMapper�� �������̽��ε� ��� �����߳�?
	//�������� �������̽��� �´� Ŭ������ ������. �ڵ带 ������ �ʾƵ� ���������� ����. 
	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}
	
	@Test
	public void testTime2() {
		log.info(mapper.getTime2());
	}
	/////////////////////////////////////////////////////////////////crud test
	@Test
	public void testTodo() {
		log.info(todoMapper.select());
	}
	
	@Test
	public void testInsert(){
		todoMapper.insert("�������");
	}
	
	@Test
	public void testDelete() {
		todoMapper.delete(3);
	}
	
	@Test
	public void testUpdate() {
		
		Todo todo = todoMapper.select().get(1);
		todo.setTitle("�����մϴ�.");
		todoMapper.update(todo);
	}
}
