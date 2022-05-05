package com.System;

import java.util.Scanner;

public class user01 {
	// 定义一个多维数组

	public static void main(String[] args) {

	}

	public static void ur() {
		String password = "1";
		String user = "1";
		for (int i = 0; i < 3; i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名");
			String us = scanner.nextLine();
			System.out.println("请输入密码");
			String word = scanner.nextLine();
			if (password.equals(word) && user.equals(us)) {
				System.out.println("登录成功!");
				break;
			} else {
				if (2 - i == 0) {
					System.out.println("你的账户已锁定，请联系相关管理员");
					System.exit(0);// 虚拟机退出系统
				} else {
					System.out.println("用户名或密码错误，还有" + (2 - i) + "机会!");
				}
			}
		}
		se();
	}

	public static void se() {
		while (true) {
			System.out.println("1-搜索书籍\t2-查看所有书籍\t3-借阅图书\t4-归还书籍\t5-我的借书情况\t6-退出用户账号");
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入你的操作：");
			String s = scanner.nextLine();
			// 使用switch提供选择
			switch (s) {
			case "1": {
				findbook();
				break;
			}
			case "2": {
				findAllbook();
				break;
			}
			case "3": {
				lend();
				break;
			}
			case "4": {
				rendr();
				break;
			}
			case"5":{
				my();
				break;
			}
			case "6": {
				BookDemo bookDemo = new BookDemo();
				bookDemo.main(null);
				break;
			}
			default:
				System.out.println("选择不存在!");
			}
		}
	}

	private static void findAllbook() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.findAllBook();

	}

	public static void lend() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.lendBook();
	}

	public static void rendr() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.rendrBook();
	}

	private static void findbook() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.findBook();
	}
	private static void my() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.myBook();
	}}
