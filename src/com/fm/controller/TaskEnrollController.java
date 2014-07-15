package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 任务报名
 * 
 * @author caizhi 2014-05-12 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/tken")
public class TaskEnrollController extends BaseController {

//	private Logger log = Logger.getLogger(this.getClass());
//
//	/**
//	 * 报名任务
//	 * 
//	 * @param enrollTkId
//	 *            任务id
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
//	@ResponseBody
//	public void enrollTask(String enrollTkId, HttpServletRequest request,
//			HttpServletResponse response) {
//		try {
//
//			Task task = super.taskService.selectOneById(new Task(enrollTkId));
//			String currentTime = methodUtil.formatDate(null, null, 0);
//
//			int timeInt = methodUtil.getDateCompare(currentTime,
//					task.getTkEndTime());
//
//			if (timeInt == -1) {
//				boolean flag = this.taskEnrollService.enrollTask(enrollTkId,
//						sessionUtil.getSessionUserId(request),
//						task.getTkUserId());
//				if (flag == true) {
//					super.printMessage("30009", "msg", "报名成功！", response);
//				} else {
//					super.printMessage("20011", "msg", "报名失败！", response);
//				}
//			} else {
//				super.printMessage("20012", "msg", "任务已经过期！", response);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			super.printMessage("40014", "msg", "系统错误！", response);
//		}
//	}
//
//	/**
//	 * 报名用户列表(所有)
//	 * 
//	 * @param tkId
//	 *            任务id
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/enlist", method = RequestMethod.GET)
//	@ResponseBody
//	public void enrollTaskList(String tkId, HttpServletRequest request,
//			HttpServletResponse response) {
//		try {
//			List<Map<String, Object>> enrollList = this.taskEnrollService
//					.queryEnrollList(tkId);
//			super.printObject("enrollList", enrollList, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			super.printMessage("40015", "msg", "系统错误！", response);
//		}
//	}

}
