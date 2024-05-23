package ontap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7629795868458453958L;
	@Id
	@Column(name = "DepartmentID")
    private int id;
	
	@Column(name = "Administrator")
    private int administrator;
	
	@Column(name = "Budget")
    private double budget;
	
	@Column(name = "Name")
    private String name;
	
	@Column(name = "StartDate")
    private LocalDateTime startDate;
	
	@OneToMany(mappedBy = "department")
	private List<Course> courses;
}
