package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 任务
 * 
 * @author caizhi 2014-05-12 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/task")
public class TaskController extends BaseController {

//	private Logger log = Logger.getLogger(this.getClass().getName());
//
//	/**
//	 * 后台添加任务
//	 * 
//	 * @param task
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/topush", method = RequestMethod.GET)
//	public String uploadApp() {
//
//		return "/task/publish";
//	}
//
//	/**
//	 * 后台添加任务
//	 * 
//	 * @param task
//	 *            tkCId --> 圈子id tkPhoto --> 图片 tkContent --> 内容 tkEndTime -->
//	 *            截止时间 tkUserId --> 发布人 tkReward --> 报酬
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/push", method = RequestMethod.POST)
//	@ResponseBody
//	public void pushTask(Task task, HttpServletRequest request,
//			HttpServletResponse response) {
//
//		boolean uploadFlag = true;
//		// 服务器上的图片路径
//		String tkPhoto = null;
//		try {
//			// 处理上传的图片
//			tkPhoto = this.uploadPicture(request,
//					CommonVariables.PICTURE_TASK_PATH);
//			if (tkPhoto != null && tkPhoto.equals("")) {
//				// 图片处理失败了
//				uploadFlag = false;
//			} else {
//				if (tkPhoto != null) {
//					tkPhoto = tkPhoto.substring(5);
//				}
//				task.setTkPhoto(tkPhoto);
//				// 添加任务
//				boolean flag = this.taskService.publishTask(task);
//				// 添加活动失败则删除图片
//				if (flag == false) {
//					uploadFlag = false;
//					this.deletePictureByServerPath(tkPhoto,
//							CommonVariables.PICTURE_TASK_PATH, request);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			super.printMessage("40011", "msg", "系统错误！", response);
//			return;
//		}
//		if (uploadFlag == true) {
//			super.printMessage("30007", "msg", "任务发布成功！", response);
//		} else {
//			super.printMessage("20009", "msg", "任务发布失败！", response);
//		}
//	}
//
//	/**
//	 * 任务列表
//	 * 
//	 * @param cId
//	 *            圈子id
//	 * @param tkId
//	 *            任务id
//	 * @param type
//	 *            nl或ul
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/tklist", method = RequestMethod.GET)
//	@ResponseBody
//	public void taskList(String cId, String tkId, String type, TaskQuery taskQuery,
//			HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//			List<Map<String, Object>> taskList = this.taskService
//					.queryTaskList(cId, tkId, type, taskQuery.getSqlWhere());
//			this.printObject("taskList", taskList, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			super.printMessage("40009", "msg", "系统错误！", response);
//		}
//	}
//
//	/**
//	 * 任务列表
//	 * 
//	 * @param cId
//	 *            圈子id
//	 * @param tkId
//	 *            任务id
//	 * @param type
//	 *            nl或ul
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	@ResponseBody
//	public void taskDetailById(String tkId, HttpServletRequest request,
//			HttpServletResponse response) {
//
//		try {
//			Map<String, Object> taskList = this.taskService
//					.taskDetailById(tkId,sessionUtil.getSessionUserId(request));
//			this.printObject("taskList", taskList, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e.getMessage());
//			super.printMessage("40009", "msg", "系统错误！", response);
//		}
//	}
}
