package com.fm.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fm.util.JsonUtil;
import com.fm.util.SessionUtil;

public class SessionInterceptor implements HandlerInterceptor {

	private static final Logger log = Logger
			.getLogger(SessionInterceptor.class);

	private static SessionUtil sessionUtil = SessionUtil.getInstance();

	private List<String> excludeUrls;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		log.debug(url);
		if (excludeUrls.contains(url)) {
			return true;
		} else {
			Object o = sessionUtil.getSessionUser(request);
			if (null != o) {
				return true;
			} else {
				PrintWriter out = null;
				try {
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("state", "20004");
					result.put("msg", "登录超时");
					response.setContentType("application/json");
					out = response.getWriter();
					String json = JsonUtil.Object2Json(result);
					log.info(result);
					out.print(json);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
					if (out != null) {
						out.flush();
						out.close();
					}
				}
				return false;
			}
		}
	}

}
