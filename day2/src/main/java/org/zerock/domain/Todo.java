package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data //get set �������
public class Todo {
	
	private Integer tno;
	private String title;
	private Date regdate;

}
