package management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

import dao.Operation;
import data.Book;

public class ManageBook {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Operation opObj;

	public ManageBook() {
		opObj = new Operation();
	}
//	public boolean checkNumber(String number) {
//		return Pattern.matches("[0-9]+", number);
//	}
//
//	public boolean checkName(String name) {
//		return Pattern.matches("[A-Za-z ]*", name);
//	}

	public void addRecord() {
		try {
			System.out.println("Enter ID:");
			int id = Integer.parseInt(br.readLine());
			List<Book> bookList = opObj.read(id);
			if (!bookList.isEmpty()) {
				System.out.println("Record Already found!");
				return;
			}
			System.out.println("Enter Name:");
			String name = br.readLine();
			System.out.println("Enter Price:");
			int price = Integer.parseInt(br.readLine());
			System.out.println("Enter No. of Pages:");
			int pageCount = Integer.parseInt(br.readLine());
			Book book = new Book();
			book.setPrice(price);
			book.setPageCount(pageCount);
			book.setName(name);
			book.setId(id);
			opObj.add(book);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readRecord() {
		try {
			System.out.println("Enter the ID:");
			int id = Integer.parseInt(br.readLine());
			List<Book> book = opObj.read(id);
			if (book.isEmpty()) {
				System.out.println("NO Record found!");
				return;
			}
			System.out.println(book.get(0).toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateRecord() {
		try {
			System.out.println("Enter the ID:");
			int id = Integer.parseInt(br.readLine());
			List<Book> list = opObj.read(id);
			if (list.isEmpty()) {
				System.out.println("Record NOT found!");
				return;
			}
			Book book = list.get(0);
			System.out.println("New Name:");
			String name = br.readLine();
			System.out.println("New Price:");
			int price = Integer.parseInt(br.readLine());
			System.out.println("New No. of Pages:");
			int pageCount = Integer.parseInt(br.readLine());
			book.setName(name);
			book.setPrice(price);
			book.setPageCount(pageCount);
			opObj.update(book);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteRecord() {
		try {
			System.out.println("Enter the ID to delete:");
			int id = Integer.parseInt(br.readLine());
			List<Book> bookList = opObj.read(id);
			if (bookList.isEmpty()) {
				System.out.println("Record NOT found!");
				return;
			}
			Book book = new Book();
			book.setId(id);
			opObj.delete(book);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void readAllRecord() {
		System.out.println("All Records:");
		List<Book> list = opObj.readAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	public void exit() {
		opObj.shutdown();
		System.out.println("Exiting!!");

	}

}
