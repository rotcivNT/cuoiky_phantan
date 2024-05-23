package ontap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "OnlineCourse")
public class OnlineCourse extends Course {
	@Column(name = "URL")
	private String url;
}
