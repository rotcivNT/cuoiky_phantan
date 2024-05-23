package ontap4.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	@Id
	protected int id;
	protected String firstName;
	protected String lastName;
	
	@Embedded
	protected Contact contact;
}