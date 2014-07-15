package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 活动
 * 
 * @author caizhi 2014-05-02 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/act")
public class ActivitiesController extends BaseController {

//	private Logger log = Logger.getLogger(this.getClass().getName());
//
//	/**
//	 * 后台添加活动页面初始化
//	 * 
//	 * @param request
//	 */
//	@RequestMapping(value = "/topush", method = RequestMethod.GET)
//	public String userInfo(HttpServletRequest request) {
//
//		List<Type> typeList = this.typeService.selectActTypeList();
//
//		request.setAttribute("typeList", typeList);
//
//		List<Circle> circleList = this.circleService.selectCircleList();
//
//		request.setAttribute("circleList", circleList);
//
//		return "/activities/publish";
//	}
//
//	/**
//	 * 后台添加活动页面初始化
//	 * 
//	 * @param request
//	 */
//	@RequestMapping(value = "/typelist", method = RequestMethod.GET)
//	@ResponseBody
//	public void typeList(HttpServletRequest request,
//			HttpServletResponse response) {
//
//		List<Type> typeList = this.typeService.selectActTypeList();
//
//		request.setAttribute("typeList", typeList);
//
//		super.printObj(typeList, response);
//	}
//
//	/**
//	 * 活动列表
//	 * 
//	 * @param cId
//	 *            圈子id
//	 * @param actId
//	 *            活动id
//	 * @param type
//	 *            nl或ul
//	 * @param request
//	 */
//	@RequestMapping(value = "/actlist", method = RequestMethod.GET)
//	@ResponseBody
//	public void actList(String cId, String actId, String type,
//			ActivitiesQuery activitiesQuery, HttpServletResponse response) {
//		try {
//			List<Map<String, Object>> actList = this.activitiesService
//					.queryActList(cId, actId, type, activitiesQuery);
//			this.printObject("actList", actList, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			super.printMessage("40009", "msg", "系统错误！", response);
//		}
//	}
//
//	/**
//	 * 后台添加活动
//	 * 
//	 * @param activities
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/push", method = RequestMethod.POST)
//	@ResponseBody
//	public void publishAct(Activities activities, String beginDate,
//			String beginTime, String endDate, String endTime,
//			HttpServletRequest request, HttpServletResponse response) {
//		boolean uploadFlag = true;
//		// 服务器上的图片路径
//		String actPhoto = null;
//		// 图片处理成功失败标志
//		try {
//			actPhoto = this.uploadPicture(request,
//					CommonVariables.PICTURE_ACT_PATH);
//			if (actPhoto != null && actPhoto.equals("")) {
//				// 图片处理失败了,删除之前上传的图片
//				uploadFlag = false;
//			} else {
//				if (actPhoto != null) {
//					actPhoto = actPhoto.substring(5);
//				}
//				activities.setActPhoto(actPhoto);
//
//				boolean flag = this.activitiesService.publishAct(activities,
//						beginDate, beginTime, endDate, endTime,
//						sessionUtil.getSessionUserId(request));
//				// 添加活动失败则删除图片
//				if (flag == false) {
//					uploadFlag = false;
//					this.deletePictureByServerPath(actPhoto,
//							CommonVariables.PICTURE_ACT_PATH, request);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//		}
//		// request.setAttribute("uploadFlag", uploadFlag);
//		// return "/activities/result";
//		super.printObj(uploadFlag, response);
//	}
//
//	/**
//	 * 发现活动
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/find", method = RequestMethod.GET)
//	@ResponseBody
//	public void findAct(HttpServletRequest request, HttpServletResponse response) {
//
//		Map<String, Object> findMap = this.activitiesService
//				.findActs(sessionUtil.getSessionUserId(request));
//
//		super.printObject("findActs", findMap, response);
//	}
//
//	/**
//	 * 发现活动
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	@ResponseBody
//	public void actDetail(String actId, HttpServletRequest request,
//			HttpServletResponse response) {
//
//		Map<String, Object> findMap = this.activitiesService.actDetailByActId(
//				actId, sessionUtil.getSessionUserId(request),
//				sessionUtil.getSessionUserScNo(request));
//
//		super.printObject("findActs", findMap, response);
//	}
//
//	/**
//	 * 发现活动
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/sysActList", method = RequestMethod.GET)
//	@ResponseBody
//	public void taskList(String cId, String page, String start, String limit,
//			String pageSize, String actTypeId, String beginTime,
//			String endTime, String keyWorld, HttpServletRequest request,
//			HttpServletResponse response) {
//
//		ActivitiesQuery actQuery = new ActivitiesQuery();
//		actQuery.setBeginTime(beginTime.replace("T", " "));
//		actQuery.setEndTime(endTime.replace("T", " "));
//		actQuery.setActTypeId(actTypeId);
//		actQuery.setKeyWorld(keyWorld);
//
//		Map<String, Object> actMap = this.activitiesService.queryActList(cId,
//				actQuery, page, start, limit);
//
//		super.printObj(actMap, response);
//		// super.printObject("actMap", actMap, response);
//	}

}
