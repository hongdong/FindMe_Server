package com.fm.test;

import java.io.File;
import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class PhotoTest {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		
		//创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        //HttpClient  
        CloseableHttpClient httpclient = httpClientBuilder.build();  
        
       // CloseableHttpClient httpclient = new DefaultHttpClient();
		// 请求处理页面
		HttpPost httppost = new HttpPost(
				"http://localhost:8080/FindMeServer/data/act/push.do");
		// 创建待处理的文件
		FileBody file = new FileBody(new File("E:\\tmp\\dengni20.jpg"));
		// 创建待处理的表单域内容文本
		//StringBody descript = new StringBody("0431.la");
		
		// 对请求的表单域进行填充
		HttpEntity req = MultipartEntityBuilder.create()  
		            .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)  
		            .addPart("files1", file)  
		            .addPart("files2", new FileBody(new File("E:\\tmp\\dengni20.jpg")))  
		            .build();  
		httppost.setEntity(req);  
		//MultipartEntity reqEntity = new MultipartEntity();
		//reqEntity.addPart("file", file);
		//reqEntity.addPart("descript", descript);
		// 设置请求
		//httppost.setEntity(reqEntity);
		// 执行
		HttpResponse response = httpclient.execute(httppost);
		// HttpEntity resEntity = response.getEntity();
		// System.out.println(response.getStatusLine());
		if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
			HttpEntity entity = response.getEntity();
			// 显示内容
			if (entity != null) {
				System.out.println(EntityUtils.toString(entity));
			}
//			if (entity != null) {
//				entity.consumeContent();
//			}
		}
	}
}
