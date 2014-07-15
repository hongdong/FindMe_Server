package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 圈子
 * 
 * @author caizhi 2014-05-04 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/circle")
public class CircleController extends BaseController {

//	private Logger log = Logger.getLogger(this.getClass().getName());
//
//	/**
//	 * 获取当前用户的圈子列表
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/cirlist", method = RequestMethod.GET)
//	@ResponseBody
//	public void circleList(HttpServletRequest request,
//			HttpServletResponse response) {
//
//		User user = sessionUtil.getSessionUser(request);
//
//		List<Map<String, Object>> cList = circleService.queryListByUserId(user
//				.getUserId());
//
//		this.printObject("circleList", cList, response);
//
//	}
//	
//	/**
//	 * 获取圈子列表
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/clist", method = RequestMethod.GET)
//	@ResponseBody
//	public void clist(HttpServletRequest request,
//			HttpServletResponse response) {
//		Map<String, Object> circleDemo = new HashMap<String, Object>();
//		List<Map<String, Object>> circleList = this.circleService.queryCircleList();
//		circleDemo.put("total", 12);
//		circleDemo.put("topics", circleList);
//		this.printObj( circleDemo, response);
//		
//	}
//
//	/**
//	 * 帮帮圈用户排名
//	 * 
//	 * @param cId
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/rank", method = RequestMethod.GET)
//	@ResponseBody
//	public void helpCircleUserRank(String cId, HttpServletRequest request,
//			HttpServletResponse response) {
//		try {
//			Map<String, Object> rankMap = this.circleService.queryRank(cId,
//					sessionUtil.getSessionUserId(request));
//			super.printObject("rankMap", rankMap, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			super.printMessage("40016", "msg", "系统错误!", response);
//		}
//
//	}

}
