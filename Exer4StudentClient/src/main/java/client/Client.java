package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entity.Department;
import entity.OnsiteCourse;
import entity.Student;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try(Socket socket = new Socket("H92M17", 7878);
				Scanner sc = new Scanner(System.in);
				){
			
			
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			int choice = 0;
			
			
			while(true) {
				System.out.println("Enter your choice: \n"
						+ "1. Get the number of courses by department\n"
						+ "2. Get the number of students enrolled in a course\n"
						+ "3. Get list of onsite courses\n");
				
				choice = sc.nextInt();
				out.writeInt(choice);
				out.flush();
				switch (choice) {
				case 1:
					Map<Department, Long> map = (Map<Department, Long>) in.readObject();
					map.entrySet()
					.stream()
					.forEach(entry -> {
						System.out.println(entry.getKey().getName() + " : " + entry.getValue());
					}); // complete the code here
					break;

				case 2:
					sc.nextLine();
					System.out.println("Enter the course title to search: ");
					String title = sc.nextLine();
					out.writeUTF(title);
					out.flush();
					
//					Receive the response from the server
					List<Student> students = (List<Student>) in.readObject();
					
					students.forEach(System.out::println);
					
					break;
					
				case 3:
					
					List<OnsiteCourse> onsiteCourses = (List<OnsiteCourse>) in.readObject();
					onsiteCourses.forEach(System.out::println);
					
					break;
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
