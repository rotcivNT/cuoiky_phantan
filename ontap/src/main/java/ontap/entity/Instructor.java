package ontap.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends Person {
	
	@Column(name = "HireDate")
	private LocalDateTime hireDate;
	
	@ManyToMany
	@JoinTable(name = "CourseInstructor", joinColumns = @JoinColumn(name = "InstructorID"), inverseJoinColumns = @JoinColumn(name = "CourseID"))
	private List<Course> courses;
}
