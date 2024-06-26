import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ontap3.dao.BookDao;
import ontap3.services.BookServices;

public class Server {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(8080)) {
			System.out.println("Server started on port 8080");
			while(true) {
				Socket client = serverSocket.accept();
				System.out.println("Client connected"	);
				System.out.println("Client IP: " + client.getInetAddress().getHostName());
				System.out.println("Client Port: " + client.getPort());
				Thread t = new Thread(new ClientHandler(client));
				t.start();
			}
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

class ClientHandler implements Runnable {
	private Socket client;
	private BookServices bookServices;

	public ClientHandler(Socket client) {
		this.client = client;
		this.bookServices = new BookDao();
	}

	@Override
    public void run() {
        try {
        	DataInputStream in = new DataInputStream(client.getInputStream());
        	ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        	
        	int choice = 0;
        	
			while ((choice = in.readInt()) != 4) {
				switch (choice) {
				case 1:
					out.writeObject(bookServices.countBooksByAuthor());
					break;
				case 2:
					String author = in.readUTF();
					int rating = in.readInt();
					out.writeObject(bookServices.listRatedBooks(author, rating));
					break;
				case 3:
					break;
				default:
					out.writeObject("Invalid choice");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}