package com.fm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fm.model.Post;
import com.fm.model.PostMessage;
import com.fm.util.CommonVariables;

/**
 * 水贴的controller
 * 
 * @author caizhi 2014-06-24 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/post")
public class PostController extends BaseController {

	@RequestMapping(value = "/topushpost", method = RequestMethod.GET)
	public String toReleasePost(Post post, HttpServletRequest request,
			HttpServletResponse response) {
		return "/post/publish";
	}

	@RequestMapping(value = "/topushpostmsg.do", method = RequestMethod.GET)
	public String toReleasePostMsg(Post post, HttpServletRequest request,
			HttpServletResponse response) {
		return "/post/postmsg";
	}

	/**
	 * 发布水贴
	 * 
	 * @param post
	 *            postContent：内容 postPhoto：图片 postOfficial:官方发布(1:官方 2：个人)
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/release_post", method = RequestMethod.POST)
	@ResponseBody
	public void releasePost(Post post, HttpServletRequest request,
			HttpServletResponse response) {
		boolean uploadFlag = true;
		// 服务器上的图片路径
		String postPhoto = null;
		// 图片处理成功失败标志
		try {
			String postId = methodUtil.getUUID();
			postPhoto = this.uploadPicture(request,
					CommonVariables.PICTURE_POST_PATH + "/" + postId, 1);
			if (postPhoto != null && postPhoto.equals("")) {
				// 图片处理失败了,删除之前上传的图片
				uploadFlag = false;
			} else {
				if (postPhoto != null) {
					postPhoto = postPhoto.substring(5);
					String[] postPhotos = postPhoto.split(",");
					post.setPostPhoto(postPhotos);
				}
				post.set_id(postId);
				boolean flag = this.postService.insertPost(post, request);
				// 添加活动失败则删除图片
				if (flag == false) {
					uploadFlag = false;
					this.deletePictureByServerPath(postPhoto,
							CommonVariables.PICTURE_POST_PATH + "/" + postId,
							1, request);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// log.error(e.getMessage());
		}
		// request.setAttribute("uploadFlag", uploadFlag);
		// return "/activities/result";
		if (uploadFlag == true)
			super.printMessage("20001", "msg", "成功!", response);
		else
			super.printMessage("10001", "msg", "失败!", response);

	}

	/**
	 * 水贴列表
	 * 
	 * @param postId
	 * @param type
	 *            nl:刷新 ol:加载更多
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/post_list", method = RequestMethod.GET)
	@ResponseBody
	public void postList(String postId, String type,
			HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> postList = this.postService.queryPostList(
				postId, type);
		super.printObject("postList", postList, response);
	}

	/**
	 * 发布留言
	 * 
	 * @param postId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/post_msg", method = RequestMethod.POST)
	@ResponseBody
	public void postMsg(PostMessage postMsg, String postId,
			HttpServletRequest request, HttpServletResponse response) {
		boolean flag = this.postService.insertPostMsg(postId, postMsg, request);
		if (flag == true)
			super.printMessage("20001", "msg", "成功!", response);
		else
			super.printMessage("10001", "msg", "失败!", response);
	}

	/**
	 * 留言列表
	 * 
	 * @param postId
	 * @param index
	 * @param type
	 *            nl:刷新 ol:加载更多
	 * @param isNews
	 *            1:消息 0:不是消息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/post_msg_list", method = RequestMethod.GET)
	@ResponseBody
	public void postMsgList(String postId, String type, String index,
			String isNews, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> postMsgMap = this.postService.queryPostMsgList(
				postId, index, type, sessionUtil.getSessionUserId(request),isNews);
		super.printObject("postMsg", postMsgMap, response);
	}

	/**
	 * 水贴点赞
	 * 
	 * @param postId
	 * @param type
	 *            p:赞 c:取消赞
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/post_praise", method = RequestMethod.GET)
	@ResponseBody
	public void postPraise(String postId, String type,
			HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		if (type != null && type.equals("p"))
			flag = this.postService.updateAddPostPraise(postId, request);
		else if (type != null && type.equals("c"))
			flag = this.postService.updateCancelPostPraise(postId, request);
		if (flag == true)
			super.printMessage("20001", "msg", "成功!", response);
		else
			super.printMessage("10001", "msg", "失败!", response);
	}

	/**
	 * 水贴点赞
	 * 
	 * @param postId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/post_cancel_praise", method = RequestMethod.GET)
	@ResponseBody
	public void postCancelPraise(String postId, HttpServletRequest request,
			HttpServletResponse response) {
		boolean flag = this.postService.updateCancelPostPraise(postId, request);
		if (flag == true)
			super.printMessage("20001", "msg", "成功!", response);
		else
			super.printMessage("10001", "msg", "失败!", response);
	}

}
