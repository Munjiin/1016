package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select now()")
	public String getTime();
	
	public String getTime2();
	//쿼리는 xml로 만들어 볼것.
}
