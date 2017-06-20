package com.ja0ck5.java8.model;

import java.util.function.Supplier;

/**
 * Created by Ja0ck5 on 2017/6/18.
 */
public class Man {

	protected String name;
	protected int age;
	protected Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		TALL, SHORT
	}

	public Man() {
	}

	public Man(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Man(String name, int age, Status status) {
		this.name = name;
		this.age = age;
		this.status = status;
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

	@Override
	public String toString() {
		return "Man{" + "name='" + name + '\'' + ", age=" + age + '}';
	}

	public static Man born(final Supplier<Man> supplier) {
		return supplier.get();
	}

	public static void grow(final Man child) {
		System.out.println("Growing  " + child/* .toString() */);
	}

	public void die() {
		System.out.println("Dieing " + this/* .toString() */);
	}

	public void sick(Man man) {
		System.out.println("Sick " + man/* .toString() */);
	}
}
