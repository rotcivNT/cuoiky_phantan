package ontap2.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "experiences")
public class Experience {
	
	private String companyName;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String description;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
}
