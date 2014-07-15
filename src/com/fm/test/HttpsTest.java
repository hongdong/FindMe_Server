package com.fm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpsTest {

	public static void main(String[] args) {
		HttpsTest.doPost();
	}
	public static void doPost() {
		CloseableHttpClient httpClient = HttpsTest.createSSLClientDefault();
		String url = "https://a1.easemob.com/fjhongdong/findme/users";

		Map<String, String> loginParams = new HashMap<String, String>();
		loginParams.put("username", "12345678901111");
		loginParams.put("password", "123456");

		JSONObject json = new JSONObject();
		json.putAll(loginParams);

		HttpPost httpPost = new HttpPost(url);

		httpPost.addHeader("Content-Type", "application/json");

		StringEntity se = new StringEntity(json.toString(), "UTF-8");

		httpPost.setEntity(se);

		// StringEntity s = new StringEntity(json.toString());
		// s.setContentEncoding("UTF-8");
		// s.setContentType("application/json");
		// httpPost.setEntity(s);

		try {
			// entity = new UrlEncodedFormEntity(paramList, "gb2312");
			// httpPost.setEntity(entity);
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity content = httpResponse.getEntity();
			String html = EntityUtils.toString(content);
			System.out.println(html);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	public static CloseableHttpClient createSSLClientDefault() {  
        try {  
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(  
                    null, new TrustStrategy() {  
                        // 信任所有  
                        @SuppressWarnings("unused")
						public boolean isTrusted(X509Certificate[] chain,
								String authType) throws CertificateException {  
                            return true;  
                        }

						@Override
						public boolean isTrusted(
								java.security.cert.X509Certificate[] chain,
								String authType)
								throws java.security.cert.CertificateException {
							// TODO Auto-generated method stub
							return true;
						}  
                    }).build();  
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(  
                    sslContext);  
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();  
        } catch (KeyManagementException e) {  
            e.printStackTrace();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } catch (KeyStoreException e) {  
            e.printStackTrace();  
        }  
        return HttpClients.createDefault();  
    }  

}
