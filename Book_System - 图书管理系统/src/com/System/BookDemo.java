package com.System;

import java.util.LinkedList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import org.w3c.dom.UserDataHandler;

public class BookDemo {
	
	static LinkedList<Book> b = new LinkedList<Book>();

	public static void main(String[] args) {

		System.out.println("----��ӭ����ͼ�����ϵͳ-----");
		System.out.println("1-�û���¼\t2-����Ա��¼\t3-�˳�ϵͳ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������ѡ��");
		String s = scanner.nextLine();
		switch (s) {
		case "1": {
			user();
			break;
		}
		case "2": {
			manager();
			break;
		}

		case "3": {
			System.out.println("�˳�ϵͳ�ɹ�!");
			System.exit(0);// ������˳�ϵͳ
			break;
		}
		}
	}

	public static void user() {
		user01 user01 = new user01();
		user01.ur();
	}

	public static void manager() {
		Manager manager = new Manager();
		manager.manager1();
	}

	public static void findAllBook() {
		if (b.size() == 0) {
			System.out.println("��ϵͳδ¼��ͼ����Ϣ��");
		} else {
			System.out.println("\t--ͼ����--\t--ͼ������--\t--ͼ������--\t--������--\t--�ִ�����--\t--�г��۸�--\t--�������--"); // �������������
			for (int i = 0; i < b.size(); i++) {
				Book book = b.get(i);
				System.out.println("\t" + book.getBookId() + "\t" + "\t" + book.getBookName() + "\t" + "\t"
						+ book.getAuthor() + "\t" + "\t" + book.getBookPress() + "\t" + "\t" + book.getShu() + "\t"
						+ "\t" + book.getPrice() + "Ԫ" + "\t" + "\t" + book.getDate());
			}
		}
	}

	public static void addBook() {

		Book book = new Book();
		Scanner scanner = new Scanner(System.in);
		System.out.println("����Ҫ���ͼ��ı��:");
		String s1 = scanner.nextLine();
		System.out.println("������ͼ������:");
		String s2 = scanner.nextLine();
		System.out.println("������ͼ������:");
		String s3 = scanner.nextLine();
		System.out.println("�����������:");
		String s4 = scanner.nextLine();
		try {
			System.out.println("�������г��۸�:");
			int s6 = scanner.nextInt();
			System.out.println("�����鼮����");
			int s7 = scanner.nextInt();
			book.setPrice(s6);
			book.setShu(s7);
		} catch (Exception e) {
			System.out.println("���ʧ��!����ļ۸��鼮��������Ϊ����!");
			System.out.println("���������!");
			addBook();
			// TODO: handle exception
		}

		book.setBookId(s1);
		book.setAuthor(s3);
		book.setBookName(s2);
		book.setBookPress(s4);

		b.add(book);
		System.out.println("��ӳɹ�!");
		Manager manager = new Manager();
		manager.select();

	}

	public static void lendBook() {
		System.out.println("������Ҫ����ͼ������:");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		Iterator<Book> iterator = b.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			// int n =book.getShu();
			// int j =book.getLendshu();
			int n = 0;
			int j = book.getLendshu();
			n = book.getShu();
			book.setLendshu(j);
			if (book.getBookName().equals(s) && book.getShu() == 0) {
				System.out.println("���鼮�Ѿ�ȫ�����");
				break;
			} else if (book.getLendshu() == 5) {
				System.out.println("��ͼ��ݹ涨ÿ��ֻ��ͬʱ����5����!");
			} else if (book.getBookName().equals(s) && book.getShu() > 0) {
				System.out.println("����ɹ�!");
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int date = calendar.get(Calendar.DATE);
				book.setDate(year + "��" + month + "��" + date + "��");
				n--;
				j++;
				book.setLendshu(j);
				System.out.println("���Ľ���ʱ����:" + book.getDate());
				calendar.set(year, month, date);
				calendar.add(Calendar.MONTH, 7);
				int year1 = calendar.get(Calendar.YEAR);
				int month1 = calendar.get(Calendar.MONTH) + 1;
				int date1 = calendar.get(Calendar.DATE);
				book.setDate1(year1 + "��" + month1 + "��" + date1 + "��");
				System.out.println("������ʱ����:" + book.getDate1());
			}

			else {
				System.out.println("����������Ʋ�����!");
			}
			user01 user01 = new user01();
			book.setShu(n);
			user01.se();
			{

			}
		}
	}

	public static void deleteBook() {

		boolean flag = true;
		System.out.println("������Ҫɾ����ͼ����:");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		Iterator<Book> iterator = b.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getBookId().equals(s)) {
				iterator.remove();
				System.out.println("ɾ���ɹ���");
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("ɾ��ʧ�ܣ�,�����ѧ������");
		}
	}

	public static void rendrBook() {
		System.out.println("��������Ҫ�黹ͼ��ı��:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Iterator<Book> iterator = b.iterator();
		if (b.size() == 0) {
			System.out.println("�㻹û�н���κ��鼮!");
		}
		while (iterator.hasNext()) {
			Book book = iterator.next();
			// int n =book.getShu();
			// int j = book.getLendshu();
			int n = 0;
			int j = 0;
			if (book.getBookId().equals(string) && book.getDate() != "δ���" && book.getLendshu() != 0) {
				System.out.println("�黹ͼ��ɹ�!");
				n++;
				j--;
				book.setLendshu(book.getLendshu() + j);
				book.setShu(book.getShu() + n);
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int date = calendar.get(Calendar.DATE);
				book.setDate1(year + "��" + month + "��" + date + "��");
				System.out.println("����ʱ��:����" + book.getDate1() + "�黹");
				if (book.getLendshu() == 0) {
					book.setDate("δ���");
				}
				break;
			} else {
				System.out.println("�黹ʧ��,���鼮û�����!");
			}
		}
	}

	public static void updateBook() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����Ҫ�޸ĵ�ͼ����:");
		String name = scanner.nextLine();
		System.out.println("����Ҫ�޸ĵ�ͼ�������:");
		String press = scanner.nextLine();
		System.out.println("����Ҫ�޸ĵ�ͼ����:");
		String Id = scanner.nextLine();
		String author = scanner.nextLine();
		System.out.println("����Ҫ�޸ĵ�ͼ����:");
		int shu = scanner.nextInt();
		System.out.println("����Ҫ�޸ĵļ۸�:");

		int price = scanner.nextInt();

		Book book2 = new Book();
		book2.setBookPress(press);
		book2.setBookName(name);
		book2.setBookId(Id);
		book2.setPrice(price);
		book2.setAuthor(author);
		book2.setShu(shu);
		// �������ϣ�ͨ��if������������޸Ķ���ѧ����Ϣ
		for (int i = 0; i < b.size(); i++) {
			Book book1 = b.get(i);
			if (book1.getBookName().equals(name)) {
				b.set(i, book2);
				System.out.println("�޸�ͼ��ɹ�");
				break;
			} else {
				System.out.println("Ҫ�޸ĵ�ͼ����Ϣ������!");

			}
		}

	}

	public static void findBook() {
		if (b.size() == 0) {
			System.out.println("��ϵͳδ¼��ͼ����Ϣ��");
		}
		System.out.println("����Ҫ�����鼮��ͼ����:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();

		for (int i = 0; i < b.size(); i++) {
			Book book = b.get(i);
			if (string.equals(book.getBookName())) {
				System.out.println("\t--ͼ����--\t--ͼ������--\t--ͼ������--\t--������--\t--�ִ�����--\t--�г��۸�--\t--�������--");
				System.out.println(book.getBookId() + book.getBookName() + book.getAuthor() + book.getBookPress()
						+ book.getShu() + book.getPrice() + book.getDate());

			} else {
				System.out.println("δ�ҵ�����鼮!");
			}
		}
	}

	public static void myBook() {
		if (b.size() == 0) {
			System.out.println("ϵͳδ¼���鼮��");
		}
		System.out.println("\t--ͼ����--\t--ͼ������--\t--�ѽ�����--\t--����ʱ��--\t--�涨����ʱ��--");
		for (int i = 0; i < b.size(); i++) {
			Book book = b.get(i);
			System.out.println("\t" + book.getBookId() + "\t" + "\t" + book.getBookName() + "\t" + "\t"
					+ book.getLendshu() + "\t" + "\t" + book.getDate() + "\t" + book.getDate1());

		}
	}
}