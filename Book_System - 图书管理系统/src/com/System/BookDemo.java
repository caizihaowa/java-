package com.System;

import java.util.LinkedList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import org.w3c.dom.UserDataHandler;

public class BookDemo {
	
	static LinkedList<Book> b = new LinkedList<Book>();

	public static void main(String[] args) {

		System.out.println("----欢迎来到图书管理系统-----");
		System.out.println("1-用户登录\t2-管理员登录\t3-退出系统");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的选择：");
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
			System.out.println("退出系统成功!");
			System.exit(0);// 虚拟机退出系统
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
			System.out.println("该系统未录入图书信息。");
		} else {
			System.out.println("\t--图书编号--\t--图书名称--\t--图书作者--\t--出版社--\t--现存数量--\t--市场价格--\t--借阅情况--"); // 解释数组的意义
			for (int i = 0; i < b.size(); i++) {
				Book book = b.get(i);
				System.out.println("\t" + book.getBookId() + "\t" + "\t" + book.getBookName() + "\t" + "\t"
						+ book.getAuthor() + "\t" + "\t" + book.getBookPress() + "\t" + "\t" + book.getShu() + "\t"
						+ "\t" + book.getPrice() + "元" + "\t" + "\t" + book.getDate());
			}
		}
	}

	public static void addBook() {

		Book book = new Book();
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入要添加图书的编号:");
		String s1 = scanner.nextLine();
		System.out.println("请输入图书名称:");
		String s2 = scanner.nextLine();
		System.out.println("请输入图书作者:");
		String s3 = scanner.nextLine();
		System.out.println("请输入出版社:");
		String s4 = scanner.nextLine();
		try {
			System.out.println("请输入市场价格:");
			int s6 = scanner.nextInt();
			System.out.println("输入书籍数量");
			int s7 = scanner.nextInt();
			book.setPrice(s6);
			book.setShu(s7);
		} catch (Exception e) {
			System.out.println("添加失败!输入的价格书籍数量必须为整数!");
			System.out.println("请重新添加!");
			addBook();
			// TODO: handle exception
		}

		book.setBookId(s1);
		book.setAuthor(s3);
		book.setBookName(s2);
		book.setBookPress(s4);

		b.add(book);
		System.out.println("添加成功!");
		Manager manager = new Manager();
		manager.select();

	}

	public static void lendBook() {
		System.out.println("请输入要借阅图书名称:");
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
				System.out.println("该书籍已经全部借出");
				break;
			} else if (book.getLendshu() == 5) {
				System.out.println("本图书馆规定每人只能同时借阅5本书!");
			} else if (book.getBookName().equals(s) && book.getShu() > 0) {
				System.out.println("借书成功!");
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int date = calendar.get(Calendar.DATE);
				book.setDate(year + "年" + month + "月" + date + "日");
				n--;
				j++;
				book.setLendshu(j);
				System.out.println("您的借书时间是:" + book.getDate());
				calendar.set(year, month, date);
				calendar.add(Calendar.MONTH, 7);
				int year1 = calendar.get(Calendar.YEAR);
				int month1 = calendar.get(Calendar.MONTH) + 1;
				int date1 = calendar.get(Calendar.DATE);
				book.setDate1(year1 + "年" + month1 + "月" + date1 + "日");
				System.out.println("最晚还书时间是:" + book.getDate1());
			}

			else {
				System.out.println("你输入的名称不存在!");
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
		System.out.println("请输入要删除的图书编号:");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		Iterator<Book> iterator = b.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getBookId().equals(s)) {
				iterator.remove();
				System.out.println("删除成功！");
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("删除失败！,输入的学号有误！");
		}
	}

	public static void rendrBook() {
		System.out.println("请输入您要归还图书的编号:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Iterator<Book> iterator = b.iterator();
		if (b.size() == 0) {
			System.out.println("你还没有借过任何书籍!");
		}
		while (iterator.hasNext()) {
			Book book = iterator.next();
			// int n =book.getShu();
			// int j = book.getLendshu();
			int n = 0;
			int j = 0;
			if (book.getBookId().equals(string) && book.getDate() != "未借出" && book.getLendshu() != 0) {
				System.out.println("归还图书成功!");
				n++;
				j--;
				book.setLendshu(book.getLendshu() + j);
				book.setShu(book.getShu() + n);
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int date = calendar.get(Calendar.DATE);
				book.setDate1(year + "年" + month + "月" + date + "日");
				System.out.println("还书时间:请您" + book.getDate1() + "归还");
				if (book.getLendshu() == 0) {
					book.setDate("未借出");
				}
				break;
			} else {
				System.out.println("归还失败,该书籍没被借出!");
			}
		}
	}

	public static void updateBook() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入要修改的图书名:");
		String name = scanner.nextLine();
		System.out.println("输入要修改的图书出版社:");
		String press = scanner.nextLine();
		System.out.println("输入要修改的图书编号:");
		String Id = scanner.nextLine();
		String author = scanner.nextLine();
		System.out.println("输入要修改的图书编号:");
		int shu = scanner.nextInt();
		System.out.println("输入要修改的价格:");

		int price = scanner.nextInt();

		Book book2 = new Book();
		book2.setBookPress(press);
		book2.setBookName(name);
		book2.setBookId(Id);
		book2.setPrice(price);
		book2.setAuthor(author);
		book2.setShu(shu);
		// 遍历集合，通过if条件控制语句修改对于学生信息
		for (int i = 0; i < b.size(); i++) {
			Book book1 = b.get(i);
			if (book1.getBookName().equals(name)) {
				b.set(i, book2);
				System.out.println("修改图书成功");
				break;
			} else {
				System.out.println("要修改的图书信息不存在!");

			}
		}

	}

	public static void findBook() {
		if (b.size() == 0) {
			System.out.println("该系统未录入图书信息。");
		}
		System.out.println("输入要查找书籍的图书名:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();

		for (int i = 0; i < b.size(); i++) {
			Book book = b.get(i);
			if (string.equals(book.getBookName())) {
				System.out.println("\t--图书编号--\t--图书名称--\t--图书作者--\t--出版社--\t--现存数量--\t--市场价格--\t--借阅情况--");
				System.out.println(book.getBookId() + book.getBookName() + book.getAuthor() + book.getBookPress()
						+ book.getShu() + book.getPrice() + book.getDate());

			} else {
				System.out.println("未找到相关书籍!");
			}
		}
	}

	public static void myBook() {
		if (b.size() == 0) {
			System.out.println("系统未录入书籍。");
		}
		System.out.println("\t--图书编号--\t--图书名称--\t--已借数量--\t--借书时间--\t--规定还书时间--");
		for (int i = 0; i < b.size(); i++) {
			Book book = b.get(i);
			System.out.println("\t" + book.getBookId() + "\t" + "\t" + book.getBookName() + "\t" + "\t"
					+ book.getLendshu() + "\t" + "\t" + book.getDate() + "\t" + book.getDate1());

		}
	}
}