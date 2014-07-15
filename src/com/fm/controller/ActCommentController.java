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
@RequestMapping(value = "/data/comt")
public class ActCommentController extends BaseController {

//	private Logger log = Logger.getLogger(this.getClass().getName());
//
//	/**
//	 * 跳转到活动评论
//	 * 
//	 * @param response
//	 */
//	@RequestMapping(value = "/tocomt", method = RequestMethod.GET)
//	public String toActComment() {
//		return "/activities/cmt/cmt";
//	}
//
//	/**
//	 * 活动评论
//	 * 
//	 * @param actComment
//	 *            cmtActId-->活动id cmtContent-->内容 cmtUserId-->发布评论的用户Id
//	 *            cmtRootId-->被回复的评论id(如果是根留言就传-1)
//	 *            cmtRepliedUserId-->被回复的用户(如果是根留言就传发布活动的用户id)
//	 *            cmtRepliedUserNickName-->被回复的用户昵称(如果是根留言就传发布活动的用户昵称)
//	 * @param response
//	 */
//	@RequestMapping(value = "/cmt", method = RequestMethod.POST)
//	@ResponseBody
//	public void actComment(ActComment actComment, HttpServletResponse response) {
//		try {
//			boolean flag = this.actCommentService.insertComment(actComment);
//			if (flag == true) {
//				super.printMessage("30005", "msg", "评论成功！", response);
//			} else {
//				super.printMessage("20008", "msg", "评论失败！", response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			super.printMessage("40007", "msg", "系统错误！", response);
//			log.error(e.getMessage());
//		}
//	}
//
//	/**
//	 * 活动评论列表
//	 * 
//	 * @param cmtId
//	 *            评论id
//	 * @param cmtActId
//	 *            活动id
//	 * @param type
//	 *            nl或ul
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/comtlist", method = RequestMethod.GET)
//	@ResponseBody
//	public void actCommentList(String cmtId, String cmtActId, String type,
//			HttpServletResponse response) {
//		try {
//			List<Map<String, Object>> actCmtList = this.actCommentService
//					.queryActCmtList(cmtId, cmtActId, type);
//			super.printObject("actCmtList", actCmtList, response);
//		} catch (Exception e) {
//			super.printMessage("40008", "msg", "系统错误！", response);
//			e.printStackTrace();
//			log.error(e.getMessage());
//		}
//	}

}
