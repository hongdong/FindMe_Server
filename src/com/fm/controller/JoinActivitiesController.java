package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 加入活动
 * 
 * @author caizhi 2014-05-06 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/joinact")
public class JoinActivitiesController extends BaseController {

//	private Logger log = Logger.getLogger(this.getClass().getName());
//
//	/**
//	 * 加入活动
//	 * 
//	 * @param joinActivities
//	 *            joinActId
//	 * @param response
//	 */
//	@RequestMapping(value = "/join", method = RequestMethod.GET)
//	@ResponseBody
//	public void JoinAct(JoinActivities joinActivities,
//			HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//			Activities activities = super.activitiesService
//					.selectOneById(joinActivities.getJoinActId());
//			String currentTime = methodUtil.formatDate(null, null, 0);
//
//			int timeInt = methodUtil.getDateCompare(currentTime,
//					activities.getActEndTime());
//
//			if (timeInt == 1 || timeInt == 0) {
//				super.printMessage("20007", "msg", "活动已经过期了！", response);
//			} else {
//				joinActivities.setJoinUserId(sessionUtil
//						.getSessionUserId(request));
//				joinActivities.setJoinId(methodUtil.getUUID());
//				joinActivities.setJoinTime(currentTime);
//
//				boolean flag = super.joinActivitiesService.insertAct(joinActivities,activities.getActUserId());
//
//				if (flag == true) {
//					super.printMessage("30004", "msg", "添加成功！", response);
//				} else {
//					super.printMessage("20006", "msg", "添加失败！", response);
//				}
//			}
//		} catch (Exception e) {
//			super.printMessage("40005", "msg", "系统错误!", response);
//			e.printStackTrace();
//			log.error(e.getMessage());
//		}
//
//	}
//
//	/**
//	 * 加入活动的用户列表
//	 * 
//	 * @param joinActId
//	 *            活动id
//	 * @param type
//	 *            nl:最新的10条 ul:加载更多
//	 * @param joinId
//	 *            最后或最前一条的id
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/joinlist", method = RequestMethod.GET)
//	@ResponseBody
//	public void JoinActList(String joinActId, String type, String joinId,
//			HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//			User mUser = super.sessionUtil.getSessionUser(request);
//			Map<String, Object> joinUserMap = super.joinActivitiesService
//					.joinUserList(joinActId, mUser.getUserId(),
//							mUser.getUserScNo(), type, joinId);
//			super.printObject("joinUserMap", joinUserMap, response);
//		} catch (Exception e) {
//			super.printMessage("40006", "msg", "系统错误!", response);
//			e.printStackTrace();
//			log.error(e.getMessage());
//		}
//
//	}
//
//	/**
//	 * 邀请活动
//	 * 
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/invitation", method = RequestMethod.GET)
//	@ResponseBody
//	public void actInvitation(String actId, String invitedUserId, String actUserId,HttpServletRequest request,
//			HttpServletResponse response) {
//		
////		Map<String, Object> findMap = this.joinActivitiesService.actInvitation(
////				actId, sessionUtil.getSessionUserId(request),
////				sessionUtil.getSessionUserScNo(request));
//		
//		//super.printObject("findActs", findMap, response);
//	}
	
}
