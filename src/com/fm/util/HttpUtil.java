package com.fm.util;

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

public class HttpUtil {

	public boolean doRegisterUser(String username, String password) {
		CloseableHttpClient httpClient = HttpUtil.createSSLClientDefault();
		String url = "https://a1.easemob.com/fjhongdong/findme/users";

		Map<String, String> loginParams = new HashMap<String, String>();
		loginParams.put("username", username);
		loginParams.put("password", password);

		JSONObject json = new JSONObject();
		json.putAll(loginParams);

		HttpPost httpPost = new HttpPost(url);

		httpPost.addHeader("Content-Type", "application/json");

		StringEntity se = new StringEntity(json.toString(), "UTF-8");

		httpPost.setEntity(se);

		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity content = httpResponse.getEntity();
			String html = EntityUtils.toString(content);
			System.out.println(html);
			if (html != null && !html.equals("")) {
				JSONObject jsonObject = JSONObject.fromObject(html);
				Object entities = jsonObject.get("entities");
				if (entities != null) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
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
