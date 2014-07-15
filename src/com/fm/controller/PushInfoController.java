package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 活动评论
 * 
 * @author caizhi 2014-05-07 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/push")
public class PushInfoController extends BaseController {

	//private Logger log = Logger.getLogger(this.getClass().getName());

//	/**
//	 * 更新推送的信息
//	 * 
//	 * @param pushInfo
//	 *            pushRegisterId 设备编码，pushType：设备类型 1：IOS 2：Android
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/push_info", method = RequestMethod.GET)
//	@ResponseBody
//	public void updatePushInfo(PushInfo pushInfo, HttpServletRequest request,
//			HttpServletResponse response) {
//		pushInfo.setPushId(this.sessionUtil.getSessionUserId(request));
//		boolean flag = this.pushInfoService.updatePushInfo(pushInfo);
//		if (flag == true) {
//			super.printMessage("30011", "msg", "更新成功！", response);
//		} else {
//			super.printMessage("20014", "msg", "更新失败！", response);
//		}
//	}
}
