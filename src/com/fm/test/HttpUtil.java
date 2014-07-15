package com.fm.test;


public class HttpUtil {

//	private static CloseableHttpClient httpClient;
//	private static CloseableHttpResponse httpResponse;
//	private static MethodUtil methodUtil = MethodUtil.getInstance();
//	
//	private static BaseDao<School> baseDao = new BaseDao<School>();
//	/**
//	 * 获取全国学校
//	 * 
//	 */
//	public static void getHttp() {
//		httpClient = HttpClients.createDefault();
//		
//		int flag = 0;
//		
//		StringBuilder txt = new StringBuilder();
//		String[] sqlArray = new String[3000];
//		int sqlIndex = 0;
//		int scNOInt = 1;
//		for (int i = 0; i < 128; i++) {
//			String url = "http://gaokao.chsi.com.cn/sch/search--searchType-1,start-"
//					+ flag + ".dhtml";
//
//			HttpGet httpGet = new HttpGet(url);
//
//			try {
//				httpResponse = httpClient.execute(httpGet);
//				HttpEntity entity = httpResponse.getEntity();
//				String html = EntityUtils.toString(entity);
//				Document doc = Jsoup.parse(html);
//				// 获取所有的table
//				Elements els = doc.select("table");
//				// 获取大学列表的table
//				Element el = els.get(els.size() - 1);
//				// 获取tr
//				els = el.select("tr");
//				els.remove(0);
//				
//				
//				for (Element element : els) {
//					Elements elss = element.select("td");
//
//					// 名称
//					Elements ells = elss.get(0).select("a");
//					String scName = ells.html();
//					// 所在地
//					Element ell = elss.get(1);
//					String scProName = ell.html();
//					// 院校隶属
//					ell = elss.get(2);
//					String scAffiliated = ell.html();
//					// 学历层次
//					ell = elss.get(3);
//					String scLevel = ell.html();
//					// 办学类型
//					ell = elss.get(4);
//					String scRunType = ell.html();
//					// 院校类型
//					ell = elss.get(5);
//					String scType = ell.html();
//
////					System.out.println("名称:" + scName + "\t所在地:" + scProName
////							+ "\t\t院校隶属:" + scAffiliated + "\t学历层次:" + scLevel
////							+ "\t办学类型:" + scRunType + "\t院校类型:" + scType);
//					String scNo = "";
//					if(scNOInt > 0 && scNOInt<10){
//						scNo = "0000" + scNOInt;
//					}else if(scNOInt >= 10 && scNOInt<100){
//						scNo = "000" + scNOInt;
//					}else if(scNOInt >= 100 && scNOInt<1000){
//						scNo = "00" + scNOInt;
//					}else if(scNOInt >= 1000 && scNOInt<10000){
//						scNo = "0" + scNOInt;
//					}
//					StringBuilder sql = new StringBuilder();
//					sql.append("insert into t_school(scId,scName,scNo,scProName,scAffiliated,scLevel,scRunType,scType) ");
//					sql.append("values('");
//					sql.append(methodUtil.getUUID());
//					sql.append("','");
//					sql.append(scName);
//					sql.append("','");
//					sql.append(scNo);
//					sql.append("','");
//					sql.append(scProName);
//					sql.append("','");
//					sql.append(scAffiliated);
//					sql.append("','");
//					sql.append(scLevel);
//					sql.append("','");
//					sql.append(scRunType);
//					sql.append("','");
//					sql.append(scType);
//					sql.append("');");
//					System.out.println(sql.toString());
//					txt.append(sql.toString() + "\r\n");
//					scNOInt++;
//					sqlArray[sqlIndex++] = sql.toString();
//				}
//				
//				// System.out.println(els);
//				//System.out.println(els);
//
//			} catch (ClientProtocolException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}finally{
//				try {
//					httpResponse.close();
//					httpClient.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			flag = flag + 20;
//		}
//		writeFile(txt.toString());
//		System.out.println(sqlArray.length);
//		baseDao.updateByBatch(sqlArray);
//	}
//
//	
//	/**
//	 * 将字符串写入文件
//	 * 
//	 * @param str
//	 */
//	public static void writeFile(String str){
//		String path = "E:\\tmp\\sql_sc.txt";
//		FileWriter writer;
//        try {
//            writer = new FileWriter(path);
//            writer.write(str);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//	}
//	
//	
//	public static void httpGetProvince(){
//		httpClient = HttpClients.createDefault();
//		String url = "http://gaokao.chsi.com.cn/sch/search--searchType-1,start-0.dhtml";
//		try {
//			HttpGet httpGet = new HttpGet(url);
//			httpResponse = httpClient.execute(httpGet);
//			HttpEntity entity = httpResponse.getEntity();
//			String html = EntityUtils.toString(entity);
//			Document doc = Jsoup.parse(html);
//			
//			Element el = doc.getElementById("sySsdm");
//			Elements els = el.children();
//			els.remove(0);
//			StringBuilder sql = new StringBuilder();
//			sql.append("insert into t_province(proId,proNo,proName) values(?,?,?);");
//			List<List<Object>> list = new ArrayList<List<Object>>();
//			int proInt = 1;
//			String proNo = "";
//			
//			for (Element element : els) {
//				if(proInt > 0 && proInt<10){
//					proNo = "0000" + proInt;
//				}else if(proInt >= 10 && proInt<100){
//					proNo = "000" + proInt;
//				}else if(proInt >= 100 && proInt<1000){
//					proNo = "00" + proInt;
//				}else if(proInt >= 1000 && proInt<10000){
//					proNo = "0" + proInt;
//				}
//				List<Object> params = new ArrayList<Object>();
//				String proId = methodUtil.getUUID();
//				String proName = element.html().trim();
//				params.add(proId);
//				params.add(proNo);
//				params.add(proName);
//				list.add(params);
//				proInt++;
//			}
//			
//			baseDao.updateByPreparedStatementByBatch(sql.toString(), list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				httpResponse.close();
//				httpClient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	public static void main(String[] args) {
//		HttpUtil.httpGetProvince();
//	}

}
