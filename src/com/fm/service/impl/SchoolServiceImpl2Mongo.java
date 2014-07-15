package com.fm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fm.service.SchoolService;

@Service("schoolService")
public class SchoolServiceImpl2Mongo extends BaseService implements
		SchoolService {

	@Override
	public List<Map<String, Object>> queryDeptBySchoolId(String schoolId) {
		return this.schoolDao.queryDeptBySchoolId(schoolId);
	}

}
