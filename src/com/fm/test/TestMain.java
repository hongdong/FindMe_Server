package com.fm.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fm.util.MethodUtil;
import com.fm.util.MongoDBUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBRef;

public class TestMain {

	public static MethodUtil methodUtil = MethodUtil.getInstance();

	//
	// public static BaseDao<School> baseDao = new BaseDao<School>();
	//
	// public void testDaoMethon() {
	// System.out.println(School.class);
	// School sc = new School();
	// sc.setScNo("00001");
	// System.out.println(sc.getClass());
	// List<Object> list = new ArrayList<Object>();
	// list.add("00001");
	// try {
	// // List<School> school = TestMain.baseDao.selectListByParams(sc,
	// // null, null);
	// School school = TestMain.baseDao.selectOneById(null, sc);
	// System.out.println(school.toString());
	// // List<School> school = (List<School>)
	// // TestMain.baseDao.findMoreRefResult("SELECT * FROM t_school",null
	// // , sc.getClass());
	// // for (School school2 : school) {
	// // System.out.println(school2.toString());
	// // }
	// //
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	public static void chenjianFormat(List<Map<String, Object>> list) {
		StringBuilder str = new StringBuilder();
		str.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
		str.append("<resources>\r\n\t<string-array name=\"college_id\">\r\n");
		StringBuilder strNo = new StringBuilder();
		StringBuilder strName = new StringBuilder();
		for (Map<String, Object> school : list) {
			String _id = (String) school.get("_id");
			strNo.append("\t\t<item >" + _id + "</item>\r\n");
			String schoolName = (String) school.get("schoolName");
			strName.append("\t\t<item >" + schoolName + "</item>\r\n");
		}
		str.append(strNo);
		str.append("\t</string-array>\r\n");
		str.append("\t<string-array name=\"college_name\">\r\n");
		str.append(strName);
		str.append("\t</string-array>\r\n");
		str.append("</resources>");
		String path = "E:\\tmp\\chenjian_sc.txt";
		TestMain.writeFile(str.toString(), path);
	}

	//
	public static void hondongFormat(List<Map<String, Object>> list) {

		// List<Map<String, Object>> list = TestMain.baseDao.queryByParams(null,
		// new School(), "scNo", "Asc");
		StringBuilder str = new StringBuilder();
		str.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
		str.append("<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\r\n");
		str.append("<plist version=\"1.0\">\r\n");
		str.append("<array>\r\n");
		StringBuilder strName = new StringBuilder();
		for (Map<String, Object> school : list) {
			String schoolName = (String) school.get("schoolName");
			String _id = (String) school.get("_id");
			strName.append("\t<dict>\r\n\t\t<key>_id</key>\r\n");
			strName.append("\t\t<string>" + _id + "</string>\r\n");
			strName.append("\t\t<key>schoolName</key>\r\n");
			strName.append("\t\t<string>" + schoolName
					+ "</string>\r\n\t</dict>\r\n");
		}
		str.append(strName);
		str.append("</array>\r\n");
		str.append("</plist>");
		String path = "E:\\tmp\\hongdong_sc.txt";
		TestMain.writeFile(str.toString(), path);
	}

	/**
	 * 将字符串写入文件
	 * 
	 * @param str
	 */
	public static void writeFile(String str, String path) {
		// String path = "E:\\tmp\\chenjian_sc.txt";
		FileWriter writer;
		try {
			writer = new FileWriter(path);
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestMain testMain = new TestMain();
		// DB db = MongoDBUtil.getDB();
		// DBCollection schoolConnection = db.getCollection("school");
		// DBCursor curs = schoolConnection.find(new BasicDBObject(),
		// new BasicDBObject("_id", 1).append("schoolName", 1));
		// List<Map<String, Object>> list = new ArrayList<Map<String,
		// Object>>();
		// while (curs.hasNext()) {
		// Map<String, Object> school = new HashMap<String, Object>();
		// school = curs.next().toMap();
		// list.add(school);
		// // System.out.println(school);
		// }
		// // testMain.hondongFormat(list);
		// testMain.chenjianFormat(list);
		// // System.out.println(obj.toArray());
		// DBCollection schoolConnection = db.getCollection("user");
		// schoolConnection.remove(new
		// BasicDBObject("_id","2014062410281828268456656"));

		// testMain.testRefBasObj();
		// testMain.query2();
		// testMain.insertPushFriend();
		testMain.a1();
	}

	public void insertPushFriend() {
		DB db = MongoDBUtil.getDB();
		DBCollection connection = db.getCollection("puser");
		BasicDBObject puser = new BasicDBObject();
		puser.put("_id", methodUtil.getUUID());
		DBRef dbRef = new DBRef(db, "user", "2014062909381246721829541");
		puser.put("user", dbRef);
		puser.put("sort", 3);
		connection.insert(puser);
	}

	public void query2() {
		DB db = MongoDBUtil.getDB();
		DBCollection connection = db.getCollection("news");
		BasicDBObject query = new BasicDBObject();
		query.put("post.$id", "2014062711435743462825309");
		query.put("users._id", "2014062615551022797410257");
		DBObject obj = connection.findOne(query,
				new BasicDBObject("users", 0).append("post", 0));
		System.out.println(obj.toMap());
	}

	public void testRefBasObj() {
		DB db = MongoDBUtil.getDB();
		DBCollection schoolConnection = db.getCollection("user");
		// schoolConnection.remove(new
		// BasicDBObject("_id","2014062410281828268456656"));
		DBRef dbRef = new DBRef(db, "post", "2014062509521826635294167");
		BasicDBObject user = new BasicDBObject();
		user.put("_id", "2014062710281828268456656");
		user.put("userNickName", "引用测试");
		user.put("post", dbRef);
		schoolConnection.insert(user);
	}

	
	
	public void a1() {
		DB db = MongoDBUtil.getDB();
		DBCollection users = db.getCollection("user");
		DBRef dbRef1 = new DBRef(db, "user", "2014070910341453956776344");
		BasicDBObject user1 = new BasicDBObject();
		user1.put("user", dbRef1);
		user1.put("isPass", 0);
		
		DBRef dbRef2 = new DBRef(db, "user", "2014070910342860714428484");
		BasicDBObject user2 = new BasicDBObject();
		user2.put("user", dbRef2);
		user2.put("isPass", 0);

		DBRef dbRef3 = new DBRef(db, "user", "2014070910343826714771967");
		BasicDBObject user3 = new BasicDBObject();
		user3.put("user", dbRef3);
		user3.put("isPass", 0);


		BasicDBObject query = new BasicDBObject();
		query.put("_id", "2014070910275727378200158");

		users.update(query, new BasicDBObject("$push", new BasicDBObject(
				"userMatch", user1)));
		users.update(query, new BasicDBObject("$push", new BasicDBObject(
				"userMatch", user2)));
		users.update(query, new BasicDBObject("$push", new BasicDBObject(
				"userMatch", user3)));
//		users.update(query, new BasicDBObject("$set", new BasicDBObject(
//				"userIsLike", 0)));
	}

	public void query() {
		DB db = MongoDBUtil.getDB();
		DBCollection connection = db.getCollection("user");
		BasicDBObject user = new BasicDBObject();
		// ReadPreference preference = ReadPreference.valueOf("$ref");
		user.put("_id", "2014062710281828268456656");
		DBObject obj = connection.findOne(user);
		// DBRefBase base = new DBRefBase(db, "post",
		// "2014062509521826635294167");
		// DBObject a = base.fetch();
		DBRef b = (DBRef) obj.get("post");
		DBObject a = b.fetch();
		// Object b = obj.get("post");
		System.out.println(a);
		System.out.println(obj.toMap());
	}
	// /**
	// * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	// * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	// *
	// * @param filePath
	// */
	// public static void readTxtFile(String filePath) {
	// try {
	// String encoding = "GBK";
	// File file = new File(filePath);
	// if (file.isFile() && file.exists()) { // 判断文件是否存在
	// InputStreamReader read = new InputStreamReader(
	// new FileInputStream(file), encoding);// 考虑到编码格式
	// BufferedReader bufferedReader = new BufferedReader(read);
	// String lineTxt = null;
	// String[] sql = new String[30383];
	// int i = 0;
	// while ((lineTxt = bufferedReader.readLine()) != null) {
	// sql[i++] = lineTxt;
	// // System.out.println(lineTxt);
	// }
	// read.close();
	// System.out.println(i);
	// baseDao.updateByBatch(sql);
	// } else {
	// System.out.println("找不到指定的文件");
	// }
	// } catch (Exception e) {
	// System.out.println("读取文件内容出错");
	// e.printStackTrace();
	// }
	//
	// }
	//
	// public void sqlWhere(String category, String beginTime, String endTime) {
	// String sqlWhere = "";
	// if (category != null) {
	// sqlWhere = " and act.actTypeId='" + category + "' ";
	// }
	// if (beginTime != null) {
	// if (!sqlWhere.equals("")) {
	// sqlWhere = sqlWhere + "and act.actBeginTime >= '" + beginTime
	// + "' ";
	// } else {
	// sqlWhere = " and act.actBeginTime >= '" + beginTime + "' ";
	// }
	// }
	// if (endTime != null) {
	// if (!sqlWhere.equals("")) {
	// sqlWhere = sqlWhere + "and act.actEndTime <= '" + endTime
	// + "' ";
	// } else {
	// sqlWhere = " and act.actEndTime <= '" + endTime + "' ";
	// }
	// }
	// System.out.println(sqlWhere);
	// }
	//
	// public void printExisit(String str, String flag) {
	// System.out.println(str.indexOf(flag));
	// }
	//
	// public static void main(String[] args) {
	// // String provice = "E:\\tmp\\provice.sql";
	// // String college = "E:\\tmp\\college.sql";
	// // String department = "E:\\tmp\\department.sql";
	// // TestMain.readTxtFile(department);
	// // chenjianFormat();
	// // hondongFormat();
	// //TestMain testMain = new TestMain();
	// // testMain.sqlWhere("2014050610102412356894", "2014-05-06 10:00:00",
	// // "2014-05-07 10:00:00");
	// System.out.println(methodUtil.getUUID());
	// // String str =
	// "http://q.qlogo.cn/qqapp/101073559/F78B194F0636943CB33B46B3D9EFBB98/40";
	// // String localPhoto = CommonVariables.PICTURE_BIG_FLAG
	// // + str.substring(str.lastIndexOf("/") + 1);
	// // // String flag = CommonVariables.SERVER_NAME;
	// // // testMain.printExisit(str, flag);
	// // System.out.println(localPhoto);
	// // System.out.println(methodUtil.getUUID());
	// // File photoFile = new
	// File("D:\\tomcat\\apache-tomcat-7.0.53\\webapps\\FindMeServer\\upload\\taskphoto\\20140513114422307l.png");
	// // if (photoFile.exists()){
	// // photoFile.delete();
	// // }
	// //System.out.println(NewsTypeEnum.CIRCLE.TYPE_NO);
	// //System.out.println(NewsSmallTypeEnum.TYPE_ONE.SMALL_TYPE_NO);
	// }
}
