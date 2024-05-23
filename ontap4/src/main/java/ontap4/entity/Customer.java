package ontap4.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@AttributeOverride(name = "id", column = @jakarta.persistence.Column(name = "customer_id"))
public class Customer extends Person {
	@Embedded
	private Address address;
}
