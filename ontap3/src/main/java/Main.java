import ontap3.dao.BookDao;

public class Main {
	public static void main(String[] args) {
		BookDao book_dao = new BookDao();
		book_dao.countBooksByAuthor().forEach((author, count) -> {
            System.out.println(author + ": " + count);
        });
	}
}