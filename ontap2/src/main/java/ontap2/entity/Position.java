package ontap2.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {
	@Id
	@Column(name = "position_id")
	private String id;
	private String name;
	private String description;
	private double salary;
	private int number;
	
	@OneToMany(mappedBy = "position")
	private List<Candidate> candidates;
	
	@OneToMany(mappedBy = "position")
	private List<Experience> experiences;
}