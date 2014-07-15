package com.fm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fm.model.BackStageUser;


@Controller
@RequestMapping(value = "/backstage")
public class BackStageController extends BaseController {
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView  backstageauth(@ModelAttribute("user") BackStageUser user,
			HttpServletRequest request,HttpServletResponse response){
		if(backStageService.auth(user.getUsername(), user.getPassword())){
			return new ModelAndView("/backstage/main");
		}else
			return new ModelAndView("/backstage/login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String  backstagelogin(HttpServletRequest request,HttpServletResponse response){
		return "/backstage/login";
	}
	
	@RequestMapping(value = "/newuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView newUserInfo(int cursor,Date date,
			HttpServletRequest request,HttpServletResponse response){
		
		if(date==null) date = new Date();
		
		List<Map<String, Object>> list = backStageService.getNewUserList(cursor, 10, date);
		return new ModelAndView("/backstage/userInfo","userList",list);
	}
}
