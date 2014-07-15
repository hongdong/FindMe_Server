package com.fm.test;

import org.apache.log4j.Logger;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import com.fm.util.CommonVariables;

public class PushMain {

	public static void main(String[] args) {
		// Logger log = Logger.getLogger(PushMain.class.getName());
		// String masterSecret = "7beff0de59e9fb3859c020bd";
		// String appKey = "aa6d24dd4cad50e82fe5a936";
		// String tag = "tag_api";
		JPushClient jpushClient = new JPushClient(
				CommonVariables.MASTER_SECRET, CommonVariables.APPKEY);

		// For push, all you need do is to build PushPayload object.

		PushPayload payload = PushPayload
				.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.registrationId("0a10127e284"))
				.setNotification(
						Notification
								.newBuilder()
								.addPlatformNotification(
										IosNotification.newBuilder()
												.setAlert("测试").setBadge(3)
												.setSound("happy")
												.setContentAvailable(false)
												.addExtra("type", "10001")
												.build()).build()).build();

		try {
			PushResult result = jpushClient.sendPush(payload);
			System.out.println(result);
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 对android和ios设备发送
		// JPushClient jpush = new JPushClient(masterSecret, appKey);

		// 对android和ios设备发送,同时指定离线消息保存时间
		// JPushClient jpush = new JPushClient(masterSecret, appKey,
		// timeToLive);

		// 指定某种设备发送
		// JPushClient jpush = new JPushClient(masterSecret, appKey,
		// DeviceEnum.Android);

		// 指定某种设备发送，并且指定离线消息保存时间
		// JPushClient jpushClient = new JPushClient(masterSecret, appKey, 0,
		// DeviceEnum.IOS, false);

		// CustomMessageParams params = new CustomMessageParams();
		// params.setReceiverType(ReceiverTypeEnum.TAG);
		// params.setReceiverValue(tag);
		//
		// MessageResult msgResult = jpushClient.sendCustomMessage("测试", "内容1",
		// params, null);
		// log.debug("responseContent - " +
		// msgResult.responseResult.responseContent);
		// if (msgResult.isResultOK()) {
		// log.info("msgResult - " + msgResult);
		// log.info("messageId - " + msgResult.getMessageId());
		// } else {
		// if (msgResult.getErrorCode() > 0) {
		// // 业务异常
		// log.warn("Service error - ErrorCode: "
		// + msgResult.getErrorCode() + ", ErrorMessage: "
		// + msgResult.getErrorMessage());
		// } else {
		// // 未到达 JPush
		// log.error("Other excepitons - "
		// + msgResult.responseResult.exceptionString);
		// }
		// }
	}

}
