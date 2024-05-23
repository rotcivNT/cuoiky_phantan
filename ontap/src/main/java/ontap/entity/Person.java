package ontap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING)
public abstract class Person {
	
	@Id
	@Column(name = "PersonID")
	protected int id;
	
	@Column(name = "FirstName")
	protected String firstName;
	
	@Column(name = "LastName")
	protected String lastName;
}
