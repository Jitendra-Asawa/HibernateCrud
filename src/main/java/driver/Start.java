package driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import management.ManageBook;
/**
 * 
 * @author Jitendra Asawa
 * CRUD operations using Hibernate with mysql
 * Created on 19 Feb, 2019
 *
 */
public class Start {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		while (choice != 6) {
			System.out.println(
					"\n			BOOK MANAGEMENT SYSTEM\nEnter your Choice:\n1. Add Book\n2. Read Book Details\n3. Update Book Details\n4. Delete Book"
							+ "\n5. Read All Book\n6. Exit!!\n Enter choice:");
			choice = Integer.parseInt(br.readLine());

			ManageBook mbObj = new ManageBook();
			switch (choice) {
			case 1: {
				mbObj.addRecord();
			}
				break;
			case 2: {
				mbObj.readRecord();
			}
				break;
			case 3: {
				mbObj.updateRecord();
			}
				break;
			case 4: {
				mbObj.deleteRecord();
			}
				break;
			case 5: {
				mbObj.readAllRecord();
			}
				break;
			case 6: {
				mbObj.exit();
			}
				break;
			default: {
				System.out.println("Make a valid choice!!");
			}
				break;
			}

		}

	}
}
