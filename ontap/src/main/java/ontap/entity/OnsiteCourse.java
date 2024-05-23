package ontap.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "OnsiteCourse")
public class OnsiteCourse extends Course {
	@Column(name = "Days")
	private String days;
	
	@Column(name = "Location")
	private String location;
	
	@Column(name = "Time")
	private LocalDateTime time;
}
