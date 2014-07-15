package com.fm.thread;


public abstract class AbstractBaseThread {

	/**
	 * 消息推送
	 * 
	 */
//	protected void pushIosNotification() {
//
//		PushPayload payload = PushPayload
//				.newBuilder()
//				.setPlatform(Platform.ios())
//				.setAudience(Audience.registrationId(equipment.getEquitNo()))
//				.setNotification(
//						Notification
//								.newBuilder()
//								.addPlatformNotification(
//										IosNotification
//												.newBuilder()
//												.setAlert(this.content)
//												.setBadge(
//														this.equipment
//																.getBadge())
//												.setSound(
//														this.equipment
//																.getSound())
//												.setContentAvailable(false)
//												.addExtras(this.params).build())
//								.build()).build();
//		try {
//			PushResult result = jpushClient.sendPush(payload);
//			System.out.println(result);
//		} catch (APIConnectionException e) {
//			e.printStackTrace();
//		} catch (APIRequestException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	protected void pushAndroidNotification() {
//		PushPayload payload = PushPayload
//				.newBuilder()
//				.setAudience(
//						Audience.registrationId(this.equipment.getEquitNo()))
//				.setPlatform(Platform.android())
//				.setNotification(
//						Notification
//								.newBuilder()
//								.setAlert(this.content)
//								.addPlatformNotification(
//										AndroidNotification.newBuilder()
//												.setBuilderId(100)
//												.addExtras(params).build())
//								.build()).build();
//		try {
//			PushResult result = jpushClient.sendPush(payload);
//			System.out.println(result);
//		} catch (APIConnectionException e) {
//			e.printStackTrace();
//		} catch (APIRequestException e) {
//			e.printStackTrace();
//		}
//	}

}
