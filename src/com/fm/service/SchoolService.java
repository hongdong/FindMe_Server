package com.fm.service;

import java.util.List;
import java.util.Map;

public interface SchoolService {

	/**
	 * 通过学校id查询院系
	 * 
	 * @param schoolId
	 * @return
	 */
	List<Map<String, Object>> queryDeptBySchoolId(String schoolId);

}
