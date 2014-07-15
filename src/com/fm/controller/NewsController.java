package com.fm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 消息
 * 
 * @author caizhi 2014-05-15 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/news")
public class NewsController extends BaseController {

	// private Logger log = Logger.getLogger(this.getClass().getName());
	//
	// /**
	// * 消息列表
	// *
	// * @param newsBigType
	// * 消息大类型<br>
	// * @param type
	// * nl或ul<br>
	// * @param newsId
	// * 消息id<br>
	// * @param response
	// */
	// @RequestMapping(value = "/newslist", method = RequestMethod.GET)
	// @ResponseBody
	// public void newsList(String newsBigType, String type, String newsId,
	// HttpServletRequest request, HttpServletResponse response) {
	//
	// try {
	// Integer newsBigTypeInt = Integer.parseInt(newsBigType);
	//
	// List<Map<String, Object>> newsList = this.newsService
	// .queryNewsList(type, newsBigTypeInt, newsId,
	// sessionUtil.getSessionUserId(request));
	// super.printObject("newsList", newsList, response);
	// } catch (Exception e) {
	// e.printStackTrace();
	// log.error(e.getMessage());
	// super.printMessage("10002", "msg", "参数错误！", response);
	// }
	//
	// }
	//
	// /**
	// * 消息列表
	// *
	// * @param newsBigType
	// * 消息大类型<br>
	// * @param newsSmalltype
	// * 消息小类别<br>
	// * @param newsSourceId
	// * 消息来源<br>
	// * @param response
	// */
	// @RequestMapping(value = "/detail", method = RequestMethod.GET)
	// @ResponseBody
	// public void newsDetail(String newsBigType, String newsSmalltype,
	// String newsSourceId, HttpServletRequest request,
	// HttpServletResponse response) {
	// try {
	// Integer newsBigTypeInt = Integer.parseInt(newsBigType);
	// Integer newsSmalltypeInt = Integer.parseInt(newsSmalltype);
	// Map<String, Object> newsDetail = this.newsService.selectNewsDetail(
	// newsBigTypeInt, newsSmalltypeInt, newsSourceId);
	// super.printObject("newsDetail", newsDetail, response);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * 消息列表（目前只有水贴消息）
	 * 
	 * @param type
	 * @param newsId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/news_list", method = RequestMethod.GET)
	@ResponseBody
	public void newsList(String type, String newsId,
			HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		newsList = this.newsService.queryNewsList(
				sessionUtil.getSessionUserId(request), type, newsId);
		super.printObject("newsList", newsList, response);
	}

	/**
	 * 消息详情
	 * 
	 * @param type
	 *            10002:水贴消息
	 * @param newsId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/news_detail", method = RequestMethod.GET)
	@ResponseBody
	public void newsDetail(String type, String newsId,
			HttpServletRequest request, HttpServletResponse response) {
//		Map<String, Object> newsDetail = this.newsService.queryNewsDetail(type,
//				newsId);
	}
}
