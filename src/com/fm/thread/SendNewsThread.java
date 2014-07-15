package com.fm.thread;


public class SendNewsThread implements Runnable {

	// public NewsDao newsDao;
	//
	// private PushInfo pushInfo;
	//
	// private News news;
	//
	// private String title;
	//
	// public SendNewsThread(News news, String title, NewsDao newsDao,
	// PushInfo pushInfo) {
	// this.news = news;
	// this.title = title;
	// this.newsDao = newsDao;
	// this.pushInfo = pushInfo;
	// }
	//
	@Override
	public void run() {
		// boolean flag = this.newsDao.insertNews(news);
		//
		// if (flag == true) {
		// if (this.pushInfo != null && this.pushInfo.getPushReceive() == 1
		// && this.pushInfo.getPushOnLine() == 1) {
		// if (this.pushInfo.getPushType() == 1)
		// this.pushIosNews(this.pushInfo.getPushRegisterId(),
		// this.news.getNewsContent(),
		// this.news.getNewsBigType());
		// else
		// this.pushAndroidNews(this.pushInfo.getPushRegisterId(),
		// this.news.getNewsContent(),
		// this.news.getNewsBigType());
		// }
		// } else {
		// System.out.println(title + "消息生成失败，推送取消...");
		// }
	}

	@SuppressWarnings("unused")
	private void pushIosNews(String registerId, String newsContent,
			Integer newsBigType) {

//		JPushClient jpushIos = new JPushClient(CommonVariables.MASTER_SECRET,
//				CommonVariables.APPKEY, 0, DeviceEnum.IOS, false);
//
//		HashMap<String, Object> extra = new HashMap<String, Object>();
//		extra.put("newBigType", newsBigType);
//		IosExtras iosExtra = new IosExtras(1, "Windows_Logon_Sound.wav");
//		extra.put("ios", iosExtra);
//
//		NotificationParams params = new NotificationParams();
//		params.setReceiverType(ReceiverTypeEnum.REGISTRATION_ID);
//		params.setReceiverValue(registerId);
//
//		// MessageResult result = jpushIos.sendNotification("测试", params,
//		// extra);
//		jpushIos.sendNotification(newsContent, params, extra);

	}

	@SuppressWarnings("unused")
	private void pushAndroidNews(String registerId, String newsContent,
			Integer newsBigType) {

//		JPushClient jpushAndroid = new JPushClient(
//				CommonVariables.MASTER_SECRET, CommonVariables.APPKEY, 0,
//				DeviceEnum.Android, false); 
//
//		NotificationParams params = new NotificationParams();
//		params.setReceiverType(ReceiverTypeEnum.REGISTRATION_ID);
//		params.setReceiverValue(registerId);
//		HashMap<String, Object> extra = new HashMap<String, Object>();
//		extra.put("newBigType", newsBigType);
//		jpushAndroid.sendNotification(newsContent, params, extra);
	}
}
