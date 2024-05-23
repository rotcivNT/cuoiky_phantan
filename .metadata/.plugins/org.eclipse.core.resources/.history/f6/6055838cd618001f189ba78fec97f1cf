package entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User {
	@OneToMany(mappedBy = "admin")
	private List<Post> posts;
}
