package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@Column(name = "post_id")
	private String id;
	private String title;
	private String contents;
	private int views;
	private int likes;
	private int shares;
	
	@Embedded
	private Approval approval;
	
	@OneToMany(mappedBy = "post")
	private Set<Comments> comments;
	
	@ManyToOne
	@JoinColumn(name = "user_name")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "admin_name")
	private User admin;
}
