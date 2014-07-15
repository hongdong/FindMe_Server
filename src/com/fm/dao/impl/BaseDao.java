package com.fm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fm.util.JsonUtil;
import com.fm.util.MethodUtil;
import com.fm.util.MongoDBUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class BaseDao {

	private Logger log = Logger.getLogger(this.getClass().getName());
	protected MethodUtil methodUtil = MethodUtil.getInstance();

	private String collectionName;

	public BaseDao(String collectionName) {
		super();
		this.collectionName = collectionName;
	}

	/**
	 * 通过json插入一条记录
	 * 
	 * @param obj
	 *            插入的对象
	 * @param collectionName
	 *            集合名称
	 */
	public void insertByJson(Object obj) {

		DB db = MongoDBUtil.getDB();
		DBCollection collection = db.getCollection(collectionName);
		String json = JsonUtil.Object2Json(obj);
		json = json.replace("id", "_id");
		DBObject dbObject = (DBObject) JSON.parse(json);
		collection.insert(dbObject);
	}

	/**
	 * 通过json插入一条记录
	 * 
	 * @param obj
	 *            插入的对象
	 * @param collName
	 *            集合名称
	 */
	public void insertByJson(Object obj, String collName) {

		DB db = MongoDBUtil.getDB();
		DBCollection collection = db.getCollection(collName);
		String json = JsonUtil.Object2Json(obj);
		json = json.replace("id", "_id");
		DBObject dbObject = (DBObject) JSON.parse(json);
		collection.insert(dbObject);
	}

	/**
	 * 通过json插入一条记录
	 * 
	 * @param obj
	 *            插入的对象
	 * @param collName
	 *            集合名称
	 */
	public void saveByJson(Object obj, String collName) {

		DB db = MongoDBUtil.getDB();
		DBCollection collection = db.getCollection(collName);
		String json = JsonUtil.Object2Json(obj);
		json = json.replace("id", "_id");
		DBObject dbObject = (DBObject) JSON.parse(json);
		collection.save(dbObject);
	}

	/**
	 * 通过json插入一条记录,并返回信息
	 * 
	 * @param obj
	 *            插入的对象
	 * @param id
	 * @return
	 */
	public boolean insertByJsonReturnInfo(Object obj, String id) {

		DB db = MongoDBUtil.getDB();
		DBCollection collection = db.getCollection(collectionName);
		String json = JsonUtil.Object2Json(obj);
		json = json.replace("id", "_id");
		DBObject dbObject = (DBObject) JSON.parse(json);
		collection.insert(dbObject);
		// 判断是否插入成功
		Map<String, Object> map = this.findOneById(id, null);
		if (map == null || map.isEmpty() == true)
			return false;
		else
			return true;
	}

	/**
	 * 通过id查询一个文档
	 * 
	 * @param _id
	 * @param collectionName
	 * @param column
	 * @return
	 */
	public Map<String, Object> findOneById(String _id, BasicDBObject column) {

		return this.findOneByParams(new BasicDBObject("_id", _id), column);
	}

	/**
	 * 通过条件查询集合
	 * 
	 * @param findConition
	 * @param column
	 * @param collectionName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> findOneByParams(BasicDBObject findConition,
			BasicDBObject column) {

		DB db = MongoDBUtil.getDB();
		DBCollection collection = db.getCollection(collectionName);
		DBObject obj = collection.findOne(findConition, column);
		Map<String, Object> resultMap = null;
		if (obj != null) {
			resultMap = obj.toMap();
		}

		return resultMap;
	}

	/**
	 * 查询多条记录
	 * 
	 * @param findConition
	 * @param column
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findByParams(BasicDBObject findConition,
			BasicDBObject sort, Integer pageSize, BasicDBObject column) {
		DB db = MongoDBUtil.getDB();
		DBCollection collection = db.getCollection(collectionName);
		DBCursor cus = collection.find(findConition, column);
		if (sort != null) {
			cus.sort(sort);
		}
		if (pageSize != null) {
			cus.limit(pageSize);
		}
		List<Map<String, Object>> listPost = new ArrayList<Map<String, Object>>();
		while (cus.hasNext()) {
			Map<String, Object> postMap = cus.next().toMap();
			listPost.add(postMap);
		}
		return listPost;
	}

	/**
	 * 更新集合
	 * 
	 * @param findObj
	 *            查询集合
	 * @param newObj
	 *            修改集合
	 * @param upsert
	 *            如果记录已经存在，更新它，否则新增一个记录 一般设置为false
	 * @param multi
	 *            如果有多个符合条件的记录，全部更新 一般设置为true
	 */
	public boolean update(BasicDBObject findObj, BasicDBObject newObj,
			boolean upsert, boolean multi) {
		DB db = MongoDBUtil.getDB();
		DBCollection collection = db.getCollection(collectionName);

		WriteResult result = collection.update(findObj, newObj, upsert, multi);
		int i = result.getN();
		if (i > 0) {
			return true;
		}
		log.error("更新数据失败:" + result.getError());
		return false;
	}

	/**
	 * 更新并查询
	 * 
	 * @param findObj
	 * @param updateObj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> findAndModify(BasicDBObject findObj,
			BasicDBObject updateObj) {

		DB db = MongoDBUtil.getDB();

		DBCollection collection = db.getCollection(collectionName);

		DBObject obj = collection.findAndModify(findObj, updateObj);

		Map<String, Object> objMap = obj.toMap();

		return objMap;

	}

	/**
	 * 删除一个对象
	 * 
	 * @param query
	 * @return
	 */
	protected boolean removeObject(BasicDBObject query) {
		DB db = MongoDBUtil.getDB();

		DBCollection collection = db.getCollection(collectionName);

		WriteResult re = collection.remove(query);

		int i = re.getN();

		return i > 0 ? true : false;
	}

}
