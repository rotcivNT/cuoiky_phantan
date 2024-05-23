package ontap.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("Student")
public class Student extends Person {
	
	@Column(name = "EnrollmentDate")
	private LocalDateTime enrollmentDate;
	
	@OneToMany(mappedBy = "student")
	private List<StudentGrade> studentGrades;
}
