package com.System;

import java.util.Scanner;

public class user01 {
	// ����һ����ά����

	public static void main(String[] args) {

	}

	public static void ur() {
		String password = "1";
		String user = "1";
		for (int i = 0; i < 3; i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("�������û���");
			String us = scanner.nextLine();
			System.out.println("����������");
			String word = scanner.nextLine();
			if (password.equals(word) && user.equals(us)) {
				System.out.println("��¼�ɹ�!");
				break;
			} else {
				if (2 - i == 0) {
					System.out.println("����˻�������������ϵ��ع���Ա");
					System.exit(0);// ������˳�ϵͳ
				} else {
					System.out.println("�û�����������󣬻���" + (2 - i) + "����!");
				}
			}
		}
		se();
	}

	public static void se() {
		while (true) {
			System.out.println("1-�����鼮\t2-�鿴�����鼮\t3-����ͼ��\t4-�黹�鼮\t5-�ҵĽ������\t6-�˳��û��˺�");
			Scanner scanner = new Scanner(System.in);
			System.out.println("��������Ĳ�����");
			String s = scanner.nextLine();
			// ʹ��switch�ṩѡ��
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
				System.out.println("ѡ�񲻴���!");
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
