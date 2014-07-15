package com.fm.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fm.service.BackStageService;
import com.fm.service.NewsService;
import com.fm.service.PostService;
import com.fm.service.SchoolService;
import com.fm.service.StatsService;
import com.fm.service.UserService;
import com.fm.util.CommonVariables;
import com.fm.util.JsonUtil;
import com.fm.util.MethodUtil;
import com.fm.util.PhotoUtil;
import com.fm.util.SessionUtil;

/**
 * 基本的Controller
 * 
 * @author caizhi 2014-05-04 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/base", produces = "application/json")
public class BaseController {

	private Logger log = Logger.getLogger(this.getClass().getName());

	protected MethodUtil methodUtil = MethodUtil.getInstance();

	protected SessionUtil sessionUtil = SessionUtil.getInstance();

	protected PhotoUtil photoUtil = PhotoUtil.getInstance();

	@Resource(name = "userService")
	protected UserService userService;

	@Resource(name = "schoolService")
	protected SchoolService schoolService;

	@Resource(name = "postService")
	protected PostService postService;
	
	@Resource(name = "newsService")
	protected NewsService newsService;

	
	@Resource(name = "backStageService")
	protected BackStageService backStageService;
	
	@Resource(name = "statsService")
	protected StatsService statsService;
	
	/**
	 * 返回信息，json格式
	 * 
	 * @param state
	 *            状态,发生错误的时候返回的错误代号，成功则没有
	 * @param response
	 */
	protected void printMessage(String state, HttpServletResponse response) {
		this.printInfo(state, null, null, response);
	}

	/**
	 * 返回信息，json格式
	 * 
	 * @param state
	 *            状态,发生错误的时候返回的错误代号，成功则没有
	 * @param msg
	 *            返回的信息
	 * @param response
	 */
	protected void printMessage(String state, String msg,
			HttpServletResponse response) {
		this.printInfo(state, null, msg, response);
	}

	/**
	 * 返回信息，json格式
	 * 
	 * @param state
	 *            状态,发生错误的时候返回的错误代号，成功则没有
	 * @param msgName
	 *            返回信息的名称，对应json中的key
	 * @param msg
	 *            返回的信息
	 * @param response
	 */
	protected void printMessage(String state, String msgName, String msg,
			HttpServletResponse response) {
		this.printInfo(state, msgName, msg, response);
	}

	/**
	 * 返回信息，json格式
	 * 
	 * @param custom
	 *            自定义返回对象
	 * @param response
	 */
	protected void printObject(Object custom, HttpServletResponse response) {
		this.printInfo(null, null, custom, response);
	}

	/**
	 * 返回信息，json格式
	 * 
	 * @param objName
	 *            返回对象的名称，对应json中的key
	 * @param custom
	 *            自定义返回对象
	 * @param response
	 */
	protected void printObject(String objName, Object custom,
			HttpServletResponse response) {
		this.printObject(null, objName, custom, response);
	}

	/**
	 * 返回信息，json格式
	 * 
	 * @param objName
	 *            返回对象的名称，对应json中的key
	 * @param custom
	 *            自定义返回对象
	 * @param response
	 */
	protected void printObject(String state, String objName, Object custom,
			HttpServletResponse response) {
		this.printInfo(state, objName, custom, response);
	}

	/**
	 * 返回信息，json格式
	 * 
	 * @param state
	 *            状态,发生错误的时候返回的错误代号，成功则没有
	 * @param objName
	 *            自定义返回对象的名称
	 * @param custom
	 *            自定义返回对象
	 * @param response
	 */
	private void printInfo(String state, String objName, Object custom,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();

		if (state != null && !state.equals(""))
			result.put("state", state);
		if (custom != null && objName != null) {
			result.put(objName, custom);
		} else if (custom != null && objName == null) {
			result.put("custom", custom);
		}
		PrintWriter out = null;
		try {
			response.setContentType("application/json");
			out = response.getWriter();
			String json = JsonUtil.Object2Json(result);
			log.info(result);
			out.print(json);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * 返回信息，json格式
	 * 
	 * @param obj
	 *            自定义返回对象
	 * @param response
	 */
	public void printObj(Object obj, HttpServletResponse response) {

		PrintWriter out = null;
		try {
			response.setContentType("application/json");
			out = response.getWriter();
			String json = JsonUtil.Object2Json(obj);
			log.info(json);
			// System.out.println(json);
			out.print(json);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * 批量上传图片
	 * 
	 * @param request
	 * @param picturePath
	 *            图片的存放路径(服务器上的路径)
	 * @param isDelFile
	 *            错误时是否删除文件夹 1：删除 0:不删除，只删除文件
	 * @return serverPhotos == null 表示没有图片<br>
	 *         serverPhotos == "" 表示上传图片失败 <br>
	 *         否则表示成功
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	protected String uploadPicture(HttpServletRequest request,
			String picturePath, int isDelFile) throws IllegalStateException,
			IOException {

		// 服务器上的图片路径
		String serverPhotos = null;

		CommonsMultipartResolver resolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		try {
			if (resolver.isMultipart(request)) {
				MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
				Iterator<String> it = multipartHttpServletRequest
						.getFileNames();
				while (it.hasNext()) {
					MultipartFile file = multipartHttpServletRequest.getFile(it
							.next());
					if (!file.isEmpty()) {
						// 原图名称
						String newFileName = methodUtil.getNewFileName();
						// 小图名称
						String smallFileName = methodUtil
								.getSmallPicName(newFileName);

						// 本地路径
						String path = methodUtil.creatAndGetRealPath(
								picturePath, request);

						// 本地上的原图路径（用于发布失败后删除本地图片）
						String localFileName = path + newFileName;
						// 本地上的小图路径（用于发布失败后删除本地图片）
						// String localSmallFileName = path + smallFileName;

						// 服务器上的路径
						String serverPhoto = CommonVariables.SERVER_NAME
								+ picturePath + "/" + smallFileName;
						// 将文件写入本地硬盘
						File localFile = new File(localFileName);
						file.transferTo(localFile);
						// 多图路径
						serverPhotos = serverPhotos
								+ CommonVariables.PICTURE_URL_FLAG
								+ serverPhoto;
						// 调用小图处理工具
						boolean picFlag = this.getSmallPicture(
								localFileName,
								path,
								smallFileName.substring(0,
										smallFileName.lastIndexOf(".")));

						// 发生错误则删除已上传的图片
						if (picFlag == false) {
							log.error("图片处理失败!");
							this.deletePictureByServerPath(serverPhotos,
									picturePath, isDelFile, request);
							serverPhotos = "";
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return serverPhotos;
	}

	/**
	 * 获取小图
	 * 
	 * @param localFileName
	 * @param path
	 * @param smallFileName
	 * @return
	 */
	protected boolean getSmallPicture(String localFileName, String path,
			String smallFileName) {
		// 调用小图处理工具
		this.photoUtil.setValue(localFileName, path, smallFileName,
				CommonVariables.PICTURE_SUFFIX, CommonVariables.PICTURE_WIDTH,
				CommonVariables.PICTURE_HEIGTH);
		return this.photoUtil.createThumbnail();
	}

	/**
	 * 删除上传失败的图片
	 * 
	 * @param localPhoto
	 *            本地上的原图路径（用于发布失败后删除本地图片）
	 * @param localSmallPhoto
	 *            本地上的小图路径（用于发布失败后删除本地图片）
	 */
	protected void deletePicture(String localPhoto, String localSmallPhoto) {
		if (localPhoto != null) {
			localPhoto = localPhoto.substring(5);
			localSmallPhoto = localSmallPhoto.substring(5);

			String[] photos = localPhoto
					.split(CommonVariables.PICTURE_URL_FLAG);
			String[] smallPhotos = localSmallPhoto
					.split(CommonVariables.PICTURE_URL_FLAG);

			for (int i = 0; i < photos.length; i++) {
				String strPhoto = photos[i];
				String strSmallPhoto = smallPhotos[i];

				File photoFile = new File(strPhoto);
				if (photoFile.exists())
					photoFile.delete();

				File smallPhotoFile = new File(strSmallPhoto);
				if (smallPhotoFile.exists())
					smallPhotoFile.delete();
			}

		}
	}

	/**
	 * 删除上传失败的图片
	 * 
	 * @param serverParh
	 *            服务器上的小图路径（用于发布失败后删除本地图片）
	 * @param localFile
	 *            本地上存放图片的文件夹（用于发布失败后删除本地图片）
	 * @param isDelFile
	 *            是否删除文件夹 1：删除 0:不删除，只删除文件
	 */
	protected void deletePictureByServerPath(String serverParh,
			String localFile, Integer isDelFile, HttpServletRequest request) {

		log.error("删除已上传的图片！");
		String userPhotoPath = methodUtil.getRealFilePath(localFile, request);

		if (serverParh != null) {

			if (isDelFile == 1) {
				methodUtil.deleteDirectory(userPhotoPath);
			} else if (isDelFile == 0) {
				String[] photos = serverParh
						.split(CommonVariables.PICTURE_URL_FLAG);

				for (int i = 0; i < photos.length; i++) {

					String strPhoto = photos[i];

					// 获取原图在服务器上的实际路径
					String serverFileName = strPhoto.substring(strPhoto
							.lastIndexOf("/") + 1);
					serverFileName = serverFileName.replace(".",
							CommonVariables.PICTURE_BIG_FLAG + ".");
					String localPhoto = userPhotoPath + "/" + serverFileName;

					// 获取小图在服务器上的实际路径
					String localSmallPhoto = userPhotoPath + "/"
							+ strPhoto.substring(strPhoto.lastIndexOf("/") + 1);

					File photoFile = new File(localPhoto);
					if (photoFile.exists())
						photoFile.delete();

					File smallPhotoFile = new File(localSmallPhoto);
					if (smallPhotoFile.exists())
						smallPhotoFile.delete();
				}
			}
		}
	}

}
