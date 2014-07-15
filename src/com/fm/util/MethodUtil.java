package com.fm.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class MethodUtil {

	/**
	 * 获取登录用户的IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "本地";
		}
		String[] ipArry = ip.split(",");
		return ipArry[0];
	}

	/**
	 * 
	 * <br>
	 * <b>功能：</b>方法功能描述<br>
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public int getRandom(int min, int max) {
		// int a = (int) (Math.random() * (44) + 23); //产生的[23,67)的随机数
		return (int) (Math.random() * (max - min) + min);
	}

	/**
	 * 
	 * <br>
	 * <b>功能：</b>获取随机数从1开始,格式10000000-99999999<br>
	 * 
	 * @param number
	 *            1
	 * @return
	 */
	public int getRandom(int number) {
		int max = 9;
		int min = 1;
		for (int i = 1; i < number; i++) {
			min = min * 10;
			max = max * 10 + 9;
		}
		return this.getRandom(min, max);
	}

	/**
	 * 
	 * <br>
	 * <b>功能：</b>20位可用于UUID<br>
	 * 
	 * @return
	 */
	public String getUUID() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
				+ getRandom(8);
	}

	/**
	 * 返回格式化后的日期格式
	 * 
	 * @param date
	 *            需要转换格式的日期
	 * @param formatString
	 *            转换的格式，自定义
	 * @param type
	 *            0：yyyy-MM-dd HH:mm:ss 1:yyyyMMddHHmmssSSS
	 * @return
	 */
	public String formatDate(Date date, String formatString, int type) {
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sf = null;
		String dateFormat = "";
		if (date == null) {
			date = new Date();
		}
		if (formatString == null) {
			if (type == 0) {
				format = "yyyy-MM-dd HH:mm:ss";
				sf = new SimpleDateFormat(format);
				dateFormat = sf.format(date);
			}
			if (type == 1) {
				format = "yyyyMMddHHmmssSSS";
				sf = new SimpleDateFormat(format);
				dateFormat = sf.format(date);
			}
		} else {
			sf = new SimpleDateFormat(formatString);
			dateFormat = sf.format(date);
		}
		return dateFormat;
	}

	/**
	 * 
	 * <br>
	 * <b>功能：</b>时间差<br>
	 * 
	 * @param current_time
	 *            当前时间
	 * @param compare_time
	 *            比较时间
	 * @return 60秒为一分钟 <br>
	 *         1--> 当前时间大于比较时间 <br>
	 *         -1 --> 当前时间小于比较时间 <br>
	 *         0 --> 当前时间等于比较时间 <br>
	 * 
	 */
	public int getDateCompare(String current_time, String compare_time) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int time = 0;
		try {
			Date c_tiem = sf.parse(current_time);
			Date com_time = sf.parse(compare_time);
			// long l = c_tiem.getTime() - com_time.getTime() > 0 ?
			// c_tiem.getTime() - com_time.getTime() : com_time.getTime() -
			// c_tiem.getTime();
			long l = c_tiem.getTime() - com_time.getTime();

			if (l > 0) {// 当前时间大于比较时间
				time = 1;
			} else if (l < 0) { // 当前时间小于比较时间
				time = -1;
			} else {// 当前时间等于比较时间
				time = 0;
			}
			// time = l / 1000; // 算出超时秒数
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @param sPath
	 *            要删除的目录或文件
	 * @return 删除成功返回 true，否则返回 false。
	 */
	public boolean DeleteFolder(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(sPath);
			} else { // 为目录时调用删除目录方法
				return deleteDirectory(sPath);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public boolean deleteDirectory(String sPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 创建一个新的文件夹
	 * 
	 * @param sPath
	 * @return
	 */
	public void createDirectory(String sPath) {
		File file = new File(sPath);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			// System.out.println("//不存在");
			file.mkdir();
		}
	}

	/**
	 * 获取文件夹的真实路径
	 * 
	 * @param localFile
	 * @param fileName
	 * @param request
	 * @return
	 */
	public String creatAndGetRealPath(String localFile,
			HttpServletRequest request) {

		String path = request.getSession().getServletContext()
				.getRealPath(localFile);

		this.createDirectory(path);

		return path + "/";
	}

	/**
	 * 获取文件夹的真实路径
	 * 
	 * @param localFile
	 * @param fileName
	 * @param request
	 * @return
	 */
	public String getRealFilePath(String localFile, HttpServletRequest request) {

		return request.getSession().getServletContext().getRealPath(localFile);
	}

	/**
	 * 上传文件重新命名
	 * 
	 * @return
	 */
	public String getNewFileName() {
		return this.formatDate(null, null, 1)
				+ CommonVariables.PICTURE_BIG_FLAG + "."
				+ CommonVariables.PICTURE_SUFFIX;
	}

	/**
	 * 通过原图片得到小图片的名称
	 * 
	 * @param bigPicName
	 *            20120506101010123l.png
	 * @return
	 */
	public String getSmallPicName(String bigPicName) {
		return bigPicName.replace(CommonVariables.PICTURE_BIG_FLAG, "");
	}

	// public static void main(String[] args) {
	// MethodUtil methodUtil = MethodUtil.getInstance();
	// String newFileName = methodUtil.getNewFileName();
	// String smallFileName = methodUtil.getSmallPicName(newFileName);
	// System.out.println("newFileName:" + newFileName + "\tsmallFileName:" +
	// smallFileName);
	// }

	/**
	 * MethodUtil 对象用于单例
	 */
	private static MethodUtil methodUtil = null;

	/**
	 * 私有构造方法，不让new实例
	 */
	private MethodUtil() {

	}

	/**
	 * 获取一个实例(单例)
	 * 
	 * @return
	 */
	public static MethodUtil getInstance() {
		if (methodUtil == null)
			methodUtil = new MethodUtil();
		return methodUtil;
	}

}
