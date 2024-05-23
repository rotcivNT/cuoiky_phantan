package ontap4.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private String city;
	private String state;
	private int zipCode;
}
