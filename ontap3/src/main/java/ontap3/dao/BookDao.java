package ontap3.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ontap3.entity.Book;
import ontap3.services.BookServices;

public class BookDao implements BookServices {

	private EntityManager em;
	
	public BookDao() {
		em = Persistence.createEntityManagerFactory("ontap3").createEntityManager();
	}
	
	@Override
	public List<Book> listRatedBooks(String author, int rating) {
		List<Book> books = new ArrayList<>();
		String sql = "select b.ISBN from books b join books_authors ba \r\n"
				+ "on b.ISBN = ba.ISBN join reviews r on b.ISBN = r.ISBN where ba.author = :author and r.rating >= :rating group by b.ISBN";
		
		Query query = em.createNativeQuery(sql);
		query.setParameter("author", author);
		query.setParameter("rating", rating);
		
		List<String> results = query.getResultList();
		for (String result : results) {
			Book b = em.find(Book.class, result);
			books.add(b);
		}
		return books;
	}

	@Override
	public Map<String, Long> countBooksByAuthor() {
		LinkedHashMap<String, Long> result = new LinkedHashMap<>();
		String sql = "select ba.author, count(*) from book_translations bt join books b\r\n"
				+ "on bt.ISBN = b.ISBN join books_authors ba\r\n"
				+ "on b.ISBN = ba.ISBN\r\n"
				+ "group by ba.author\r\n"
				+ "order by ba.author";
		Query query = em.createNativeQuery(sql);
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {
			String author = (String) objects[0];
			int count = (Integer) objects[1];
			result.put(author, Long.valueOf(count));
		}
		return result;
	}

}
