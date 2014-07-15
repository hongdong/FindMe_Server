package com.fm.thread;

import java.util.List;
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

public class PushListInfoThread implements Runnable {

	private List<Equipment> equipments;
	@SuppressWarnings("unused")
	private String title;
	private String content;
	private Map<String, String> params;

	private JPushClient jpushClient;

	public PushListInfoThread(List<Equipment> equipments, String title,
			String content, Map<String, String> params) {
		super();
		this.equipments = equipments;
		this.title = title;
		this.content = content;
		this.params = params;
		jpushClient = new JPushClient(CommonVariables.MASTER_SECRET,
				CommonVariables.APPKEY);
	}

	@Override
	public void run() {

		if (this.equipments != null && this.equipments.isEmpty() == false) {

			for (Equipment equipment : equipments) {
				if (equipment != null) {
					if (equipment.getOsType().equals("1")){
						//System.out.println("LOG ||  equipments:" + equipment.getEquitNo());
						try {
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						this.pushIosNotification(equipment);
					}
					else
						this.pushAndroidNotification(equipment);
				}
			}

		} else {
			System.out.println(content + "消息生成失败，推送取消...");
		}
	}

	/**
	 * 消息推送
	 * 
	 * @param equipment
	 * 
	 */
	private void pushIosNotification(Equipment equipment) {

		PushPayload payload = PushPayload
				.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.registrationId(equipment.getEquitNo()))
				.setNotification(
						Notification
								.newBuilder()
								.addPlatformNotification(
										IosNotification.newBuilder()
												.setAlert(this.content)
												.setBadge(equipment.getBadge())
												.setSound(equipment.getSound())
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

	private void pushAndroidNotification(Equipment equipment) {
		PushPayload payload = PushPayload
				.newBuilder()
				.setAudience(Audience.registrationId(equipment.getEquitNo()))
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
