package ontap3.services;

public interface ReviewServices {
	public boolean updateReviews(String isbn, String readerID, int rating, String comment);
}
