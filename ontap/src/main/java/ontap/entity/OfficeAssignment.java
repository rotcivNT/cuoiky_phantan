package ontap.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OfficeAssignment {
	
	@Column(name = "Location")
	private String location;
	
	@Column(name = "Timestamp")
	private Timestamp timestamp;
	
	@Id
	@OneToOne
	@JoinColumn(name = "InstructorID")
	private Instructor instructor;
}
