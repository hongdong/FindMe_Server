package com.fm.model;

public class UserDemo {

	private String name;

	private int age;

	private String email;

	private String birthDay;

	private long deposit;

	private boolean isIt;

	private String sex;

	public UserDemo(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public UserDemo(String name, int age, String email, String birthDay,
			long deposit, boolean isIt, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.birthDay = birthDay;
		this.deposit = deposit;
		this.isIt = isIt;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public long getDeposit() {
		return deposit;
	}

	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}

	public boolean isIt() {
		return isIt;
	}

	public void setIt(boolean isIt) {
		this.isIt = isIt;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UserDemo() {
		super();
	};

}
