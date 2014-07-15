package com.fm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 学校的controller
 * 
 * @author caizhi 2014-04-28 1.0
 * 
 */
@Controller
@RequestMapping(value = "/data/school")
public class SchoolController extends BaseController {

	// private Logger log = Logger.getLogger(this.getClass().getName());
	//
	// /**
	// * 初始化添加院系页面中的省份列表
	// *
	// * @param request
	// * @return
	// */
	// @RequestMapping(value = "/ini", method = RequestMethod.GET)
	// public String toAddDepartment(HttpServletRequest request) {
	// List<Province> proList = this.provinceService.queryList();
	// request.setAttribute("proList", proList);
	// return "/add_dept";
	// }
	//
	// /**
	// * 通过省份查询学校，ajax请求
	// *
	// * @param province
	// * 省份编码<br>
	// * @param request
	// */
	// @RequestMapping(value = "/changsc", method = RequestMethod.GET)
	// public void selectSchool(School School, HttpServletRequest request,
	// HttpServletResponse response) {
	// List<School> scList = this.schoolService.queryList(School);
	// // super.printObject(scList, response);
	// PrintWriter out = null;
	// try {
	// response.setContentType("application/json");
	// out = response.getWriter();
	// String json = JsonUtil.Object2Json(scList);
	// log.info(json);
	// out.print(json);
	// out.flush();
	// out.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * 通过省份查询学校，ajax请求
	// *
	// * @param province
	// * 省份编码<br>
	// * @param request
	// */
	// @RequestMapping(value = "/adddept", method = RequestMethod.POST)
	// public String addDept(ScDepartment scDepartment, String deptNameFormat,
	// HttpServletRequest request, HttpServletResponse response) {
	// boolean flag = this.schoolService.insertBatch(scDepartment,
	// deptNameFormat);
	// request.setAttribute("flag", flag);
	// return "/result";
	// }
	//
	// /**
	// * 通过省份查询学校，ajax请求
	// *
	// * @param province
	// * 省份编码<br>
	// * @param request
	// */
	// /*
	// * @RequestMapping(value = "/adddept", method = RequestMethod.GET) public
	// * void addDept(ScDepartment scDepartment,String deptNameFormat,
	// * HttpServletRequest request, HttpServletResponse response) { boolean
	// flag
	// * = this.schoolService.insertBatch(scDepartment,deptNameFormat);
	// * PrintWriter out = null; try {
	// * response.setContentType("application/json"); out =
	// response.getWriter();
	// * String json = JsonUtil.Object2Json(flag); super.log.info(json);
	// * out.print(json); out.flush(); out.close(); } catch (Exception e) {
	// * e.printStackTrace(); } }
	// */
	//
	/**
	 * 通过schoolId获取院系列表
	 * 
	 * @param schoolId
	 *            学校Id
	 * @param response
	 */
	@RequestMapping(value = "/dept_list", method = RequestMethod.GET)
	@ResponseBody
	public void deptListByScNo(String schoolId, HttpServletResponse response) {
		if (schoolId != null && !schoolId.equals("")) {
			List<Map<String, Object>> deptList = this.schoolService
					.queryDeptBySchoolId(schoolId);
			this.printObject("department", deptList, response);
		} else {
			super.printMessage("10001", "msg", "参数错误！", response);
		}
	}
}
