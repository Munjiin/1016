package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data //get set �������
public class Todo {
	
	private Integer tno;
	private String title;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") //이걸 추가 
	private Date regdate;

}
