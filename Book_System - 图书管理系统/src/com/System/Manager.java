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
		System.out.println("���������Ա�û���");
		String us = scanner.nextLine();
		System.out.println("����������");
		String word = scanner.nextLine();
		if (password.equals(word) && user.equals(us)) {
			System.out.println("��¼�ɹ�!");
			select();
		} else {
			System.out.println("�û������������!");
			BookDemo bookDemo = new BookDemo();
			bookDemo.main(null);
		}

	}

	public static void select() {
		System.out.println("1-���ͼ��\t2-ɾ��ͼ��\t3-�޸�ͼ����Ϣ\t4-�鿴ȫ��ͼ��\t5-�˳�����Ա�˺�");
		System.out.println("��������Ҫִ�еĲ���:");
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
