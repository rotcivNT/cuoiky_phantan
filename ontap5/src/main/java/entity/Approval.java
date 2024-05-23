package entity;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
public class Approval {
	private LocalDate approvedDate;
	private String status;
}
