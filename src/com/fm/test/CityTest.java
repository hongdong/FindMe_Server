package com.fm.test;


public class CityTest {
	
//	public static MethodUtil methodUtil = MethodUtil.getInstance();
//	
//	public static BaseDao<Province> baseDao = new BaseDao<Province>();
//	
//	public static BaseDao<School> baseDao2 = new BaseDao<School>();
//	
//	public static void main(String[] args) {
//		//String path = "E:\\FindMe\\data\\city_excel.xls";
//		//CityTest.cityData(path);
//		String path = "E:\\FindMe\\data\\school_city.xls";
//		CityTest.schoolCityData(path);
//	}
//	
//	public static void schoolCityData(String path){
//		//HSSFWorkbook
//		
//		try {
//			FileInputStream fileInputStream = new FileInputStream(new File(path));
//			
//			HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
//			
//			int totleSheetNum = wb.getNumberOfSheets();
//			System.out.println(totleSheetNum);
//			
//			HSSFSheet sheet = wb.getSheetAt(0);
//			
//			int lastRowNum = sheet.getLastRowNum();
//			
//			System.out.println(lastRowNum);
////			
//			String[] citySqlArray = new String[1107];
//			int j = 0;
//			for (int i = 0; i < lastRowNum+1; i++) {
//				HSSFRow row = sheet.getRow(i);
//				HSSFCell cell2 = row.getCell(3);
//				String schoolName = cell2.getStringCellValue();
//				
//				HSSFCell cell1 = row.getCell(4);
////				if(i == 168){
////					Object cellObj = getCellValue(cell1);
////					System.out.println(cellObj.toString());
////				}
//				String cityName = "";
//				
//				Object cellObj = getCellValue(cell1);
//				
//				if(cellObj == null || cellObj.equals("")){
//					System.out.println("111111111");
//					continue;
//				}else {
//					cityName = (String) cellObj;
//				}
//				String lastChar = cityName.charAt(cityName.length()-1) + "";
//				
//				if(lastChar.equals("市")){
//					cityName = cityName.substring(0, cityName.length()-1);
//				}
//				String sql1 = "select * from t_city where cityName=?";
//				List<Object> params1 = new ArrayList<Object>();
//				params1.add(cityName);
//				City city = baseDao2.findSimpleRefResult(sql1, params1, City.class);
//				
//				//String cityName = cell1.getStringCellValue();
//				//System.out.println("schoolName:" + schoolName + "\tcityName:" + cityName);
//				if(city != null){
//					String cityNo = city.getCityNo();
//					String sql = "select * from t_school where scName=?";
//					List<Object> params = new ArrayList<Object>();
//					params.add(schoolName);
//					School school = baseDao2.findSimpleRefResult(sql, params, School.class);
//					if(school != null){
//						String scId = school.getScId();
//						StringBuilder sqlSc = new StringBuilder();
//						sqlSc.append("update t_school set scCityName='"+cityName+"',scCityNo='"+cityNo+"' where scId='"+scId+"';");
//						citySqlArray[j++] = sqlSc.toString();
//					}
//				}
//				
//			}
//			System.out.println(j);
//			
//			baseDao.updateByBatch(citySqlArray);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
//	/**
//	 * 获取cell的值
//	 * 
//	 * @param cell
//	 * @return cell的值，Object类型
//	 */
//	public static Object getCellValue(HSSFCell cell) {
//		Object obj = null;
//		try {
//			switch (cell.getCellType()) {
//			case HSSFCell.CELL_TYPE_NUMERIC: // 数字
//				obj = cell.getNumericCellValue();
//				break;
//			case HSSFCell.CELL_TYPE_STRING: // 字符串
//				obj = cell.getStringCellValue();
//				break;
//			case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
//				obj = cell.getBooleanCellValue();
//				break;
//			case HSSFCell.CELL_TYPE_FORMULA: // 公式
//				obj = cell.getCellFormula();
//				break;
//			case HSSFCell.CELL_TYPE_BLANK: // 空值
//				obj = null;
//				break;
//			case HSSFCell.CELL_TYPE_ERROR: // 故障
//				obj = null;
//				break;
//			default:
//				obj = null;
//				break;
//			}
//		} catch (Exception e) {
//			obj = null;
//		}
//		return obj;
//	}
//	
//	public static void cityData(String path){
//		//HSSFWorkbook
//		
//		try {
//			FileInputStream fileInputStream = new FileInputStream(new File(path));
//
//			HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
//			
//			int totleSheetNum = wb.getNumberOfSheets();
//			System.out.println(totleSheetNum);
//			
//			HSSFSheet sheet = wb.getSheetAt(0);
//			
//			int lastRowNum = sheet.getLastRowNum();
//			
//			System.out.println(sheet.getLastRowNum());
//			
//			String tmpProName = "北京";
//			int cityNoInt = 0;
//			String[] citySqlArray = new String[655];
//			int j = 0;
//			for (int i = 1; i < lastRowNum-2; i++) {
//				HSSFRow row = sheet.getRow(i);
//				
//				
//				HSSFCell cell2 = row.getCell(2);
//				String cityName = cell2.getStringCellValue();
//				
//				
//				
//				HSSFCell cell1 = row.getCell(1);
//				String proName = cell1.getStringCellValue();
//				
//				String pn = "";
//				if(cityName.equals("北京") || cityName.equals("天津") || cityName.equals("上海") || cityName.equals("重庆")){
//					proName = "%" + cityName + "%";
//					pn = cityName;
//				}else{
//					pn = proName.substring(0, 2);
//					proName = "%" + pn + "%";
//				}
//				
//				List<Object> params = new ArrayList<Object>();
//				params.add(proName);
//				String sql = "select * from t_province where proName like ?";
//				
//				Province province = baseDao.findSimpleRefResult(sql, params, Province.class);
//				
//				String proNo = province.getProNo();
//				
//				if(pn.equals(tmpProName)){
//					cityNoInt++;
//				}else {
//					tmpProName = pn;
//					cityNoInt = 1;
//				}
//				
//				String cityNo = "";
//				if(cityNoInt > 0 && cityNoInt<10){
//					cityNo = proNo + "0" + cityNoInt;
//				}else if(cityNoInt >= 10 && cityNoInt<100){
//					cityNo = proNo + "" + cityNoInt;
//				}
//				
//				
//				//System.out.println(province);
//				
//				
//				StringBuilder citySql = new StringBuilder();
//				String cityId = methodUtil.getUUID();
//				citySql.append("insert into t_city(cityId,cityNo,cityName,cityProNo) values(");
//				citySql.append("'"+cityId+"','"+cityNo+"','"+cityName+"','"+proNo+"');");
//				
//				citySqlArray[j++] = citySql.toString();
//				System.out.println(citySql.toString());
//				System.out.println(j);
//				//System.out.println("proName:" + proName + "\tcity:" + cityName);
//				
//			}
//			
//			baseDao.updateByBatch(citySqlArray);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
