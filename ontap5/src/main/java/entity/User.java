package entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = jakarta.persistence.DiscriminatorType.STRING)
public class User {
	@Id
	@Column(name = "user_name")
	protected String username;
	
	@Column(name = "password")
	protected String password;
	
	@Column(name = "email")
	protected String email;
	

	@OneToMany(mappedBy = "user")
	private List<Comments> comments;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
}
