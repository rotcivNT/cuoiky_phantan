package ontap3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Reviews {
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	@Id
	private Person reviewer;
	
	@ManyToOne
	@JoinColumn(name = "ISBN")
	@Id
	private Book book;
}
