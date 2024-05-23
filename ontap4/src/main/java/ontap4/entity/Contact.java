package ontap4.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contact {
	private String phone;
	private String email;
}
