package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 任务留言
 * 
 * @author caizhi 2014-05-12 1.0
 *
 */
@Controller
@RequestMapping(value = "/data/tkmsg")
public class TaskMessageController extends BaseController{

//	private Logger log = Logger.getLogger(this.getClass().getName());
//	
//	/**
//	 * 跳转到活动评论
//	 * 
//	 * @param response
//	 */
//	@RequestMapping(value = "/tomsg", method = RequestMethod.GET)
//	public String toActComment() {
//		return "/task/taskmessage/msg";
//	}
//	
//	/**
//	 * 任务评论
//	 * 
//	 * @param taskMessage
//	 *            tmTkId-->任务id tmContent-->内容 tmUserId-->发布评论的用户Id
//	 *            tmRootId-->被回复的评论id(如果是根留言就传-1)
//	 *            tmRepliedUserId-->被回复的用户(如果是根留言就传发布活动的用户id)
//	 *            tmRepliedUserNickName-->被回复的用户昵称(如果是根留言就传发布活动的用户昵称)
//	 * @param response
//	 */
//	@RequestMapping(value = "/push", method = RequestMethod.POST)
//	@ResponseBody
//	public void publishTaskMsg(TaskMessage taskMessage,
//			HttpServletRequest request, HttpServletResponse response) {
//		try {
//			boolean flag = this.taskMessageService.insertMessage(taskMessage);
//			if (flag == true) {
//				super.printMessage("30008", "msg", "留言成功！", response);
//			} else {
//				super.printMessage("20010", "msg", "留言失败！", response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			super.printMessage("40012", "msg", "系统错误！", response);
//			log.error(e.getMessage());
//		}
//	}
//	
//	/**
//	 * 活动列表
//	 * 
//	 * @param tmTkId
//	 *            任务id
//	 * @param tmId
//	 *            留言id
//	 * @param type
//	 *            nl或ul
//	 * @param request
//	 */
//	@RequestMapping(value = "/msglist", method = RequestMethod.GET)
//	@ResponseBody
//	public void taskMsgList(String tmTkId, String tmId, String type,
//			HttpServletRequest request, HttpServletResponse response) {
//		try {
//			Map<String, Object> taskMsgMap = this.taskMessageService
//					.queryTaskMsgList(tmTkId, tmId, type,sessionUtil.getSessionUserId(request));
//			this.printObject("taskMsgMap", taskMsgMap, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			super.printMessage("40013", "msg", "系统错误！", response);
//		}
//	}

}
