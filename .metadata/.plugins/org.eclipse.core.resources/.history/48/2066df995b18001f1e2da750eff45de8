package ontap4.entity;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@AttributeOverride(name = "id", column = @jakarta.persistence.Column(name = "staff_id"))
public class Staff extends Person {
	private byte active;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Staff manager;
	
	@OneToMany(mappedBy = "manager")
	private List<Staff> staffs;
}
