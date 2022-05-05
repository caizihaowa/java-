package com.System;

import java.security.PublicKey;
import java.util.Scanner;

public class Manager {

	public static void main(String[] args) {

	}

	public static void manager1() {
		String password = "1";
		String user = "1";
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入管理员用户名");
		String us = scanner.nextLine();
		System.out.println("请输入密码");
		String word = scanner.nextLine();
		if (password.equals(word) && user.equals(us)) {
			System.out.println("登录成功!");
			select();
		} else {
			System.out.println("用户名或密码错误!");
			BookDemo bookDemo = new BookDemo();
			bookDemo.main(null);
		}

	}

	public static void select() {
		System.out.println("1-添加图书\t2-删除图书\t3-修改图书信息\t4-查看全部图书\t5-退出管理员账号");
		System.out.println("请输入您要执行的操作:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		switch (string) {
		case "1": {
			add();
			break;
		}
		case "2": {
			delete();
			break;
		}
		case "3": {
			update();
			break;
		}
		case "4": {
			findAll();
			break;
		}
		case "5": {
			BookDemo bookDemo = new BookDemo();
			bookDemo.main(null);
			break;
		}

		default:
			break;
		}
		select();
	}

	private static void add() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.addBook();
	}

	private static void findAll() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.findAllBook();

	}

	private static void delete() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.deleteBook();

	}

	private static void update() {
		BookDemo bookDemo = new BookDemo();
		bookDemo.updateBook();

	}
}
