package com.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 私信
 * 
 * @author caizhi 2014-05-14 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/letter")
public class LetterController extends BaseController {

	// private Logger log = Logger.getLogger(this.getClass().getName());

//	/**
//	 * 发送私信
//	 * 
//	 * @param letter
//	 *            letterReceiveUserId --> 接收方id <br>
//	 *            letterContent --> 内容<br>
//	 * @param response
//	 */
//	@RequestMapping(value = "/push", method = RequestMethod.POST)
//	@ResponseBody
//	public void JoinAct(Letter letter, HttpServletRequest request,
//			HttpServletResponse response) {
//		boolean flag = this.letterService.publishLetter(letter,
//				sessionUtil.getSessionUserId(request),
//				sessionUtil.getSessionUserNickName(request));
//		if (flag == true) {
//			super.printMessage("30010", "msg", "私信发送成功！", response);
//		} else {
//			super.printMessage("20013", "msg", "私信发送失败！", response);
//		}
//	}

}
