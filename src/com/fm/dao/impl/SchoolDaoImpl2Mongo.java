package com.fm.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.dao.SchoolDao;
import com.fm.model.School;

@Repository("schoolDao")
public class SchoolDaoImpl2Mongo extends BaseDao implements SchoolDao {

	private static String schoolCollection = "school";

	public SchoolDaoImpl2Mongo() {
		super(schoolCollection);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryDeptBySchoolId(String schoolId) {

		Map<String, Object> schoolMap = super.findOneById(schoolId, null);
		if (schoolMap != null && schoolMap.isEmpty() == false)
			return (List<Map<String, Object>>) schoolMap.get("department");
		return null;
	}

	@Override
	public List<School> getSchoolByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addSchool(School school) {
		// TODO Auto-generated method stub
		return false;
	}

}
