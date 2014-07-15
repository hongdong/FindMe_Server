package com.fm.thread;

import java.util.Map;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import com.fm.model.Equipment;
import com.fm.util.CommonVariables;

public class PushInfoThread implements Runnable {

	private Equipment equipment;
	@SuppressWarnings("unused")
	private String title;
	private String content;
	private Map<String, String> params;

	private JPushClient jpushClient;

	public PushInfoThread(Equipment equipment, String title, String content,
			Map<String, String> params) {
		super();
		this.equipment = equipment;
		this.title = title;
		this.content = content;
		this.params = params;
		jpushClient = new JPushClient(CommonVariables.MASTER_SECRET,
				CommonVariables.APPKEY);
	}

	@Override
	public void run() {

		if (this.equipment != null) {
			if (this.equipment.getOsType().equals("1"))
				this.pushIosNotification();
			else
				this.pushAndroidNotification();
		} else {
			System.out.println(content + "消息生成失败，推送取消...");
		}
	}

	/**
	 * 消息推送
	 * 
	 */
	private void pushIosNotification() {

		PushPayload payload = PushPayload
				.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.registrationId(equipment.getEquitNo()))
				.setNotification(
						Notification
								.newBuilder()
								.addPlatformNotification(
										IosNotification
												.newBuilder()
												.setAlert(this.content)
												.setBadge(
														this.equipment
																.getBadge())
												.setSound(
														this.equipment
																.getSound())
												.setContentAvailable(false)
												.addExtras(this.params).build())
								.build()).build();
		try {
			PushResult result = jpushClient.sendPush(payload);
			System.out.println(result);
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
			e.printStackTrace();
		}

	}

	private void pushAndroidNotification() {
		PushPayload payload = PushPayload
				.newBuilder()
				.setAudience(
						Audience.registrationId(this.equipment.getEquitNo()))
				.setPlatform(Platform.android())
				.setNotification(
						Notification
								.newBuilder()
								.setAlert(this.content)
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setBuilderId(100)
												.addExtras(params).build())
								.build()).build();
		try {
			PushResult result = jpushClient.sendPush(payload);
			System.out.println(result);
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
			e.printStackTrace();
		}
	}
}
