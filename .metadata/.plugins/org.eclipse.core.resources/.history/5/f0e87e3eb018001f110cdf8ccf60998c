package ontap3.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {
	@Id
	@Column(name = "publisher_id")
	private String id;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private String email;
	
	@OneToMany(mappedBy = "publisher")
	private List<Book> books;
}
