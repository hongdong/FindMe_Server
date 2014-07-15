package com.fm.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fm.util.CommonVariables;

/**
 * 用户
 * 
 * @author caizhi 2014-05-04 1.0
 * 
 */
@Controller
@RequestMapping(value = "/wechar/public/")
public class WeChatController {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping(value = "/grant", method = RequestMethod.GET)
	@ResponseBody
	public String grantOrLogin(String signature, String timestamp, String nonce,
			String echostr, HttpServletRequest request,
			HttpServletResponse response) {
		log.error("signature:" + signature + "\ttimestamp:" + timestamp + "\tnonce:" + nonce);
		log.error("echostr:" + echostr);
		String[] strArray = new String[]{CommonVariables.WECHAR_TOKEN,timestamp,nonce};
		Arrays.sort(strArray);
		String ss = "";
		for (String str : strArray) {
			ss = ss + str;
		}
		log.error("ss:" + ss);
		ss = this.SHA1(ss);
		log.error("SHA1(ss):" + ss);
		if(signature.equals(ss)){
			return echostr;
		}
		return null;
	}
	
	 public String SHA1(String inStr) {
	        MessageDigest md = null;
	        String outStr = null;
	        try {
	            md = MessageDigest.getInstance("SHA-1");     //选择SHA-1，也可以选择MD5
	            byte[] digest = md.digest(inStr.getBytes());       //返回的是byet[]，要转化为String存储比较方便
	            outStr = bytetoString(digest);
	        }
	        catch (NoSuchAlgorithmException nsae) {
	            nsae.printStackTrace();
	        }
	        return outStr;
	    }
	    
	    
	    public String bytetoString(byte[] digest) {
	        String str = "";
	        String tempStr = "";
	        
	        for (int i = 1; i < digest.length; i++) {
	            tempStr = (Integer.toHexString(digest[i] & 0xff));
	            if (tempStr.length() == 1) {
	                str = str + "0" + tempStr;
	            }
	            else {
	                str = str + tempStr;
	            }
	        }
	        return str.toLowerCase();
	    }

}
