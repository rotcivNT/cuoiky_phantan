package ontap1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import ontap1.enums.Type;

@Entity
@Table(name = "foods")
public class Food extends Item {
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(name = "preparation_time")
	private int preparationTime;
	
	@Column(name = "serving_time")
	private int servingTime;
}