package entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments {
	
	private String contents;
	
	private LocalDateTime commentDate;
	
	private int likes;
	
	@ManyToOne
	@JoinColumn(name = "user_name")
	@Id
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	@Id
	private Post post;
	
}
