package com.fm.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fm.util.JdbcUtil;
import com.fm.util.MethodUtil;
import com.fm.util.MongoDBUtil;
import com.fm.util.ReflectUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.Hash;

public class SchoolDataTest {
	private Logger log = Logger.getLogger(this.getClass().getName());
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;

	protected MethodUtil methodUtil = MethodUtil.getInstance();
	protected ReflectUtil reflectUtil = ReflectUtil.getInstance();

	/**
	 * 获取单个对象
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Map<String, Object> findSimpleResult(String sql, List<Object> params) {

		Map<String, Object> map = new HashMap<String, Object>();
		int index = 1;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			log.info(pstmt.toString());
			ResultSetMetaData metaData = rs.getMetaData();
			int col_len = metaData.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < col_len; i++) {
					String cols_name = metaData.getColumnLabel(i + 1);
					Object cols_value = rs.getObject(cols_name);

					if (cols_value != null && cols_value instanceof Date) {
						cols_value = methodUtil.formatDate((Date) cols_value,
								null, 0);
					}

					map.put(cols_name, cols_value);
				}
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return map;
	}

	/**
	 * 获取对象集合
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> findMoreResult(String sql,
			List<Object> params) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			log.info(pstmt.toString());
			ResultSetMetaData metaData = rs.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnLabel(i + 1);
					Object cols_value = rs.getObject(cols_name);

					if (cols_value != null && cols_value instanceof Date) {
						cols_value = methodUtil.formatDate((Date) cols_value,
								null, 0);
					}

					map.put(cols_name, cols_value);
				}
				list.add(map);
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return list;
	}

	public void test(){
		String sqlSchool = "SELECT s.scId, s.scName,s.scNo, p.proId, p.proName, c.cityId, c.cityName FROM t_school s LEFT JOIN t_province p ON s.scProNo = p.proNo LEFT JOIN t_city c ON s.scCityNo = c.cityNo";
		SchoolDataTest test = new SchoolDataTest();
		List<Map<String, Object>> schoolList = test.findMoreResult(sqlSchool, null);
		
		List<DBObject> dbobj = new ArrayList<DBObject>();
		for (Map<String, Object> map : schoolList) {
			String scNo = (String) map.get("scNo");
			String sqlDept = "SELECT d.deptId, d.deptName FROM t_sc_department d WHERE d.deptScNo = '"+scNo+"'";
			List<Map<String, Object>> deptList = test.findMoreResult(sqlDept, null);
			Map<String, Object> school = new HashMap<String, Object>();
			school.put("_id", map.get("scId"));
			school.put("schoolName", map.get("scName"));
			Map<String, Object> province = new HashMap<String, Object>();
			province.put("_id", map.get("proId"));
			province.put("provinceName", map.get("proName"));
			Map<String, Object> city = new HashMap<String, Object>();
			city.put("_id", map.get("cityId"));
			city.put("cityName", map.get("cityName"));
			
			school.put("province", province);
			school.put("city", city);
			school.put("department", deptList);
			
			//System.out.println(school);
			DBObject object = new BasicDBObject(school);
			dbobj.add(object);
		}
		DB db = MongoDBUtil.getDB();
		DBCollection schoolConnection = db.getCollection("school");
		schoolConnection.insert(dbobj);
		
		System.out.println(schoolList.size());
	}
	
	public static void main(String[] args) {
		DB db = MongoDBUtil.getDB();
		DBCollection schoolConnection = db.getCollection("school");
		DBCursor obj = schoolConnection.find(new BasicDBObject("schoolName","福建工程学院"));
		System.out.println(obj.toArray());
	}

}
