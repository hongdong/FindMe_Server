package com.fm.test;

import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class HttpTest {

	public static void main(String[] args) throws UnsupportedEncodingException, KeyManagementException, NoSuchAlgorithmException {
//		String str = HttpTest.doPost();
		HttpTest.test();
//		System.out.println(str);
	}

	
	public static void test() throws KeyManagementException, NoSuchAlgorithmException{
		 String host = "https://a1.easemob.com";
	        String orgName = "fjhongdong";
	        String appName = "findme";
	        String username = "test";
	        String password = "123456";

	        Client client = getClient(true);
	        WebTarget target = client.target(host).path("/{org}/{app}/token").resolveTemplate("org", orgName).resolveTemplate("app", appName);
	        Map<String, String> payload = new HashMap<String, String>();
	        payload.put("grant_type", "password");
	        payload.put("username", username);
	        payload.put("password", password);
	        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).buildPost(Entity.json(payload)).invoke();
	        String result = response.readEntity(String.class);
	        System.out.println(result);
	}
	
	
	private static Client getClient(boolean https) throws NoSuchAlgorithmException, KeyManagementException {
		 ClientBuilder builder = ClientBuilder.newBuilder();
		 
	        if (https) {
	            HostnameVerifier hv = new HostnameVerifier() {
	                @Override
	                public boolean verify(String hostname, SSLSession session) {
	                    System.out.println("Warning: URL Host: " + hostname + " vs. "
	                            + session.getPeerHost());
	                    return true;
	                }
	            };
	            // Create a trust manager that does not validate certificate chains
	            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
	                public void checkClientTrusted(
	                        java.security.cert.X509Certificate[] certs,
	                        String authType) {
	                }

	                public void checkServerTrusted(
	                        java.security.cert.X509Certificate[] certs,
	                        String authType) {
	                }

	                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                    return null;
	                }
	            }};

	            // Install the all-trusting trust manager
	            SSLContext sc = SSLContext.getInstance("SSL");

	            sc.init(null, trustAllCerts, new java.security.SecureRandom());
	            builder.sslContext(sc).hostnameVerifier(hv);
	        }
	        return builder.build();
	}


	public static void doPost()  {

//		SSLContext sslcontext = SSLContexts.custom().useTLS()
//				.loadTrustMaterial(null, new TrustStrategy() {
//					@Override
//					public boolean isTrusted(X509Certificate[] chain,
//							String authType) throws CertificateException {
//						return true;
//					}
//				}).build();
//		SSLIOSessionStrategy sslSessionStrategy = new SSLIOSessionStrategy(
//				sslcontext, new AllowAll());
//
//		Registry<SchemeIOSessionStrategy> sessionStrategyRegistry = RegistryBuilder
//				.<SchemeIOSessionStrategy> create()
//				.register("http", NoopIOSessionStrategy.INSTANCE)
//				.register("https", sslSessionStrategy).build();
//
//		DefaultConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(
//				IOReactorConfig.DEFAULT);
//		PoolingNHttpClientConnectionManager connectionManager = new PoolingNHttpClientConnectionManager(
//				ioReactor, sessionStrategyRegistry);
//		connectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS.get());
//		connectionManager.setDefaultMaxPerRoute(ROUTE_CONNECTIONS.get());
//
//		RequestConfig requestConfig = RequestConfig.custom()
//				.setSocketTimeout(SOCKET_TIMEOUT.get())
//				.setConnectTimeout(CONNECT_TIMEOUT.get())
//				.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT.get())
//				.setStaleConnectionCheckEnabled(STALE_CONNECTION_CHECK.get())
//				.build();
//
//		CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
//				.setSSLStrategy(sslSessionStrategy)
//				.setConnectionManager(connectionManager)
//				.setDefaultRequestConfig(requestConfig).build();

//		httpClient.start();
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		String url = "https://a1.easemob.com/fjhongdong/findme/users";
//
//		Map<String, String> loginParams = new HashMap<String, String>();
//		loginParams.put("username", "1234567890");
//		loginParams.put("password", "123456");
//
//		JSONObject json = new JSONObject();
//		json.putAll(loginParams);
//
//		HttpPost httpPost = new HttpPost(url);
//
//		httpPost.addHeader("Content-Type", "application/json");
//
//		StringEntity se = new StringEntity(json.toString(), "UTF-8");
//
//		httpPost.setEntity(se);
//
//		// StringEntity s = new StringEntity(json.toString());
//		// s.setContentEncoding("UTF-8");
//		// s.setContentType("application/json");
//		// httpPost.setEntity(s);
//
//		try {
//			// entity = new UrlEncodedFormEntity(paramList, "gb2312");
//			// httpPost.setEntity(entity);
//			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//
//			HttpEntity content = httpResponse.getEntity();
//			String html = EntityUtils.toString(content);
//			return html;
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	private static class AllowAll implements X509HostnameVerifier {
//		@Override
//		public void verify(String s, SSLSocket sslSocket) throws IOException {
//		}
//
//		@Override
//		public void verify(String s, X509Certificate x509Certificate)
//				throws SSLException {
//		}
//
//		@Override
//		public void verify(String s, String[] strings, String[] strings2)
//				throws SSLException {
//		}
//
//		@Override
//		public boolean verify(String s, SSLSession sslSession) {
//			return true;
//		}
//	}

	// 加入请求参数
	// List<NameValuePair> paramList = new ArrayList<NameValuePair>();
	// for (String key : loginParams.keySet()) {
	// if (key != null) {
	// paramList
	// .add(new BasicNameValuePair(key, loginParams.get(key)));
	// }
	// }
	// UrlEncodedFormEntity entity;
	//
	// httpPost.setEntity(new UrlEncodedFormEntity(paramList, HTTP.UTF_8));

	// List<NameValuePair> params=new ArrayList<NameValuePair>();
	// //建立一个NameValuePair数组，用于存储欲传送的参数
	// params.add(new BasicNameValuePair("data",json.toString()));
	// //添加参数
	// httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
	}
}
