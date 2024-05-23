package entity;

import jakarta.persistence.EntityManagerFactory;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("ontap5");
	}
}
