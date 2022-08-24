package com.qa.project;

public class Customers {

	private String firstName;
	private String surName;
	private int age;
	private char sex;

	public Customers() {
		super();
	}

	public Customers(String firstName, String surName, int age, char sex) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.age = age;
		this.sex = sex;
	}

	public String toString() {
		return "Customer [Name=" + firstName + ", Surname=" + surName + ", Age=" + age + ", Sex=" + sex + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

}
