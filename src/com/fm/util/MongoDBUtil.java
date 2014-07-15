package com.fm.util;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;

public class MongoDBUtil {

	private static Logger mongoUitlLog = Logger.getLogger(MongoDBUtil.class
			.getName());

	/**
	 * 关闭mongodb数据库连接
	 */
	// private static void stopMondoDBConn() {
	// if (null != mongo) {
	// if (null != db) {
	// // 结束Mongo数据库的事务请求
	// try {
	// db.requestDone();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// try {
	// mongo.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// mongo = null;
	// db = null;
	// }
	// }

	/**
	 * 获取mongodb数据库连接
	 */
	// private static void startMongoDBConn() {
	// try {
	// // Mongo(p1, p2):p1=>IP地址 p2=>端口
	// mongo = new Mongo("127.0.0.1", 27017);
	// // 根据mongodb数据库的名称获取mongodb对象
	// db = mongo.getDB("fanmi");
	// // 校验用户密码是否正确
	// if (!db.authenticate("sdap", "sdap123".toCharArray())) {
	// System.out.println("连接MongoDB数据库,校验失败！");
	// } else {
	// System.out.println("连接MongoDB数据库,校验成功！");
	// }
	// } catch (UnknownHostException e) {
	// e.printStackTrace();
	// } catch (MongoException e) {
	// e.printStackTrace();
	// }
	// }

	private static Mongo mongo = null;
	private static DB db = null;

	private MongoDBUtil() {

	}

	/**
	 * 根据名称获取DB，相当于是连接
	 * 
	 * @param dbName
	 * @return
	 */
	public static DB getDB(String dbName) {
		if (mongo == null) {
			// 初始化
			init();
		}
		db = mongo.getDB(dbName);
		boolean flag = true;
		if (!db.isAuthenticated()) {
			flag = db.authenticate("findme", "findme".toCharArray());
		}
		if (flag == false) {
			mongoUitlLog.error("数据库认证失败！");
			System.out.println("数据库认证失败！");
		}
		return db;
	}

	/**
	 * 根据名称获取DB，相当于是连接
	 * 
	 * @param dbName
	 * @return
	 */
	public static DB getDB() {
		if (mongo == null) {
			// 初始化
			init();
		}
		db = mongo.getDB(CommonVariables.DB_NAME);
		boolean flag = true;
		if (!db.isAuthenticated()) {
			flag = db.authenticate("findme", "findme".toCharArray());
		}
		if (flag == false) {
			mongoUitlLog.error("数据库认证失败！");
			System.out.println("数据库认证失败！");
		}
		return db;
	}

	/**
	 * 初始化连接池，设置参数。
	 */
	private static void init() {
		MongoOptions options = new MongoOptions();
		options.autoConnectRetry = true;
		options.connectionsPerHost = 1000;
		options.maxWaitTime = 5000;
		options.socketTimeout = 0;
		options.connectTimeout = 15000;
		options.threadsAllowedToBlockForConnectionMultiplier = 5000;
		// 事实上，Mongo实例代表了一个数据库连接池，即使在多线程的环境中，一个Mongo实例对我们来说已经足够了
		// mongo = new Mongo(new
		// ServerAddress(DBMongoConfig.getHost(),DBMongoConfig.getPort()),options);
		// mongo = new Mongo(DBMongoConfig.getHost(),DBMongoConfig.getPort());
		// or, to connect to a replica set, supply a seed list of members
		// Mongo m = new Mongo(Arrays.asList(new ServerAddress("localhost",
		// 27017),
		// new ServerAddress("localhost", 27018),
		// new ServerAddress("localhost", 27019)));

		// 注意Mongo已经实现了连接池，并且是线程安全的。
		// 大部分用户使用mongodb都在安全内网下，但如果将mongodb设为安全验证模式，就需要在客户端提供用户名和密码：
		// boolean auth = db.authenticate(myUserName, myPassword);

		// String confFilePath = "";
		// ConfTool conf = new ConfTool(confFilePath);
		// String host = conf.getValue("host");// 主机名
		// int port = new Integer(conf.getValue("port"));// 端口
		// int poolSize = new Integer(conf.getValue("poolSize"));// 连接数量
		// int blockSize = new Integer(conf.getValue("blockSize")); // 等待队列长度
		// 其他参数根据实际情况进行添加
		try {
			// mongo = new Mongo(host, port);
			mongo = new Mongo("114.215.115.33", options);
			// mongo = new Mongo("127.0.0.1", 27017);
			// MongoOptions opt = mongo.getMongoOptions();
			// opt.connectionsPerHost = poolSize;
			// opt.threadsAllowedToBlockForConnectionMultiplier = blockSize;
		} catch (UnknownHostException e) {
			// log error
			mongoUitlLog.equals("创建mongo对象错误：" + e.getMessage());
		} catch (MongoException e) {
			// log error
			mongoUitlLog.equals("创建mongo对象错误：" + e.getMessage());
		}
	}
}
