package ontap.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course {
	@Id
	@Column(name = "CourseID")
	protected int id;
	
	@Column(name = "credits")
	protected int credits;
	
	@Column(name = "Title")
	protected String title;
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID")
	protected Department department;
	
	@OneToMany(mappedBy = "course")
	private List<StudentGrade> studentGrades;
	
	@ManyToMany(mappedBy = "courses")
	private List<Instructor> instructors;
}
