package com.fm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页
 * 
 * @author caizhi 2014-05-22 1.0
 * 
 */
@Controller
@RequestMapping(value = "/home/page")
public class HomeController {
	

	@RequestMapping(value = "/home_page", method = RequestMethod.GET)
	public String homePage(HttpServletRequest request,
			HttpServletResponse response) {
		return "/../../index";
	}
	
	@RequestMapping(value = "/about_fm", method = RequestMethod.GET)
	public String aboutFanMi(HttpServletRequest request,
			HttpServletResponse response) {
		return "/home/about_fm";
	}
	
	@RequestMapping(value = "/about_us", method = RequestMethod.GET)
	public String aboutUs(HttpServletRequest request,
			HttpServletResponse response) {
		return "/home/about_us";
	}
	
	@RequestMapping(value = "/join_us", method = RequestMethod.GET)
	public String joinUs(HttpServletRequest request,
			HttpServletResponse response) {
		return "/home/join_us";
	}
	
	@RequestMapping(value = "/dynamic_fm", method = RequestMethod.GET)
	public String dynamicFm(HttpServletRequest request,
			HttpServletResponse response) {
		return "/home/dynamic_fm";
	}
	
	@RequestMapping(value = "/phone_us", method = RequestMethod.GET)
	public String phoneUs(HttpServletRequest request,
			HttpServletResponse response) {
		return "/home/phone_us";
	}
}
