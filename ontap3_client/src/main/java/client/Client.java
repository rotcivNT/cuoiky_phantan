package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ontap3.entity.Book;

public class Client {
	public static void main(String[] args) {
		System.out.println("Client started");
		
		try (Socket socket = new Socket("r0tc1v", 8080); Scanner sc = new Scanner(System.in);) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			int choice = 0;

			System.out.println("Connected to server");
			while(true) {
				System.out.println("Input: ");
				choice = sc.nextInt();
				out.writeInt(choice);
				out.flush();
				
				switch(choice) {
				case 1:
					Map<String, Long> results = (Map<String, Long>) in.readObject();
					results.forEach((author, count) -> {
						System.out.println(author + ": " + count);
					});
					break;
				case 2:
					System.out.println("Input author: ");
					String author = sc.next();
					sc.nextLine();
					System.out.println("Input rating: ");
					int rating = sc.nextInt();
					out.writeUTF(author);
					out.writeInt(rating);
					out.flush();
					
					List<Book> books = (List<Book>) in.readObject();
					books.forEach(book -> {
						System.out.println(book);
					});
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Connected to server err");
			e.printStackTrace();
		}
	}
}
