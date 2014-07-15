package com.fm.dao;

import java.util.List;
import java.util.Map;

import com.fm.model.School;

public interface SchoolDao {

	/**
	 * 通过学校id查询院系
	 * 
	 * @param schoolId
	 * @return
	 */
	List<Map<String, Object>> queryDeptBySchoolId(String schoolId);

	
	List<School> getSchoolByCity(String city);
	
	public boolean addSchool(School school);
}
