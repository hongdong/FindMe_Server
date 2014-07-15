package com.fm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fm.model.DeptTree;
import com.fm.model.UserDemo;

@Controller
@RequestMapping(value = "/admin/sys")
public class SystemController extends BaseController {

	@RequestMapping(value = "/togrid", method = RequestMethod.GET)
	public String toAddDepartment(HttpServletRequest request) {
		// List<Province> proList = this.provinceService.queryList();
		// request.setAttribute("proList", proList);
		return "/fanmi/grid01";
	}

	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public String toLogin(HttpServletRequest request) {
		// List<Province> proList = this.provinceService.queryList();
		// request.setAttribute("proList", proList);
		return "/fanmi/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(String userName, String password,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userName:" + userName + "\tpassword:" + password);
		//User user = this.userService.systemLogin(userName,password,request);
		Map<String, Object> result = new HashMap<String, Object>();
//		if(user == null){
//			result.put("success", false);
//		}else{
//			result.put("success", true);
//			result.put("userNickName", user.getUserNickName());
//			result.put("userLastLoginTime", user.getUserLastLoginTime());
//			result.put("userLoginCount", user.getUserLoginCount());
//			result.put("userLoginIp",MethodUtil.getIpAddr(request));
//			sessionUtil.setSessionAttribute("userLoginIp", MethodUtil.getIpAddr(request), request);
//		}
		super.printObj(result, response);
	}
	
	@RequestMapping(value = "/sys_logout", method = RequestMethod.GET)
	public String sysLogout(String userName, String password,
			HttpServletRequest request, HttpServletResponse response) {
		this.sessionUtil.loginOut(request);
		return "/fanmi/grid01";
	}

	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	@ResponseBody
	public void getUserList(String page, String start, String limit,
			HttpServletRequest request, HttpServletResponse response) {

		if (page.equals("1")) {
			List<UserDemo> list = new ArrayList<UserDemo>();
			Map<String, Object> userdemo = new HashMap<String, Object>();

			String date = methodUtil.formatDate(null, "yyyy/MM/dd HH:mm:ss", 0);

			UserDemo user1 = new UserDemo("张三", 25, "zhans@126.com", date,
					5700, true, "男");
			UserDemo user2 = new UserDemo("李四", 26, "lis@126.com", date, 8000,
					true, "女");
			UserDemo user3 = new UserDemo("王五", 23, "wangw@126.com", date,
					4500, false, "男");
			UserDemo user4 = new UserDemo("赵六", 27, "zhaol@126.com", date,
					3000, true, "男");
			UserDemo user5 = new UserDemo("洪七", 25, "hongq@126.com", date,
					2500, false, "女");
			UserDemo user6 = new UserDemo("马八", 25, "mab@126.com", date, 2500,
					false, "男");// "mab@126.com"

			list.add(user1);
			list.add(user2);
			list.add(user3);
			list.add(user4);
			list.add(user5);
			list.add(user6);
			userdemo.put("total", 12);
			userdemo.put("topics", null);
			super.printObj(userdemo, response);
		} else if (page.equals("2")) {
			List<UserDemo> list = new ArrayList<UserDemo>();
			Map<String, Object> userdemo = new HashMap<String, Object>();

			String date = methodUtil.formatDate(null, "yyyy/MM/dd HH:mm:ss", 0);

			UserDemo user1 = new UserDemo("张九", 25, "zhans@126.com", date,
					5700, true, "男");
			UserDemo user2 = new UserDemo("李十", 26, "lis@126.com", date, 8000,
					true, "女");
			UserDemo user3 = new UserDemo("王十一", 23, "wangw@126.com", date,
					4500, false, "男");
			UserDemo user4 = new UserDemo("赵十二", 27, "zhaol@126.com", date,
					3000, true, "男");
			UserDemo user5 = new UserDemo("洪十三", 25, "hongq@126.com", date,
					2500, false, "女");
			UserDemo user6 = new UserDemo("马十四", 25, "mab@126.com", date, 2500,
					false, "男");// "mab@126.com"

			list.add(user1);
			list.add(user2);
			list.add(user3);
			list.add(user4);
			list.add(user5);
			list.add(user6);
			userdemo.put("total", 12);
			userdemo.put("topics", null);
			super.printObj(userdemo, response);

		}
	}

	@RequestMapping(value = "/depttree", method = RequestMethod.GET)
	@ResponseBody
	public void getDeptTree(HttpServletRequest request,
			HttpServletResponse response) {

		DeptTree root = new DeptTree("root", "00", false, false);
		DeptTree dept1 = new DeptTree("技术部门", "01", false, false);
		DeptTree dept2 = new DeptTree("后勤部门", "02", false, false);
		DeptTree dept3 = new DeptTree("研发部门", "0101", false, true);
		DeptTree dept4 = new DeptTree("实施部门", "0102", false, true);
		DeptTree dept5 = new DeptTree("人事部", "0201", false, true);
		DeptTree dept6 = new DeptTree("行政部", "0202", false, true);

		Set<DeptTree> children1 = new HashSet<DeptTree>();
		children1.add(dept3);
		children1.add(dept4);

		dept1.setChildren(children1);

		Set<DeptTree> children2 = new HashSet<DeptTree>();
		children2.add(dept5);
		children2.add(dept6);

		dept2.setChildren(children2);

		Set<DeptTree> children = new HashSet<DeptTree>();
		children.add(dept1);
		children.add(dept2);
		root.setChildren(children);

		super.printObj(root, response);
	}

	@RequestMapping(value = "/delusers", method = RequestMethod.POST)
	@ResponseBody
	public void delUser(String ids, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(ids);
		super.printMessage("30001", "msg", "删除", response);
	}
}
