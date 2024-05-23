package ontap3.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "people")
public class Person {
	@Id
	@Column(name = "person_id")
	private int id;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	private String address;
	private String email;
	
	@Column(name = "professional_title")
	private String professionalTitle;
	
	@OneToMany(mappedBy = "reviewer")
	private List<Reviews> reviews;
}
