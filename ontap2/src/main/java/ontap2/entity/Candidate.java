package ontap2.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate {
	@Id
	@Column(name = "candidate_id")
	private String id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "year_of_birth")
	private String yearOfBirth;
	
	private String gender;
	
	private String email;
	
	private String phone;
	
	private String desscription;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	@OneToMany(mappedBy = "candidate")
	private List<Certificate> certificates;
	
	@OneToMany(mappedBy = "candidate")
	private List<Experience> experiences;
}