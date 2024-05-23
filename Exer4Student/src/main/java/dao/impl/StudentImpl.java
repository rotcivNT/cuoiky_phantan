package dao.impl;

import java.util.List;

import dao.StudentDao;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class StudentImpl implements StudentDao{
	
	private static final String PERSISTENCE_UNIT_NAME = "jpa-mssql";
	private EntityManager em;
	
	public StudentImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<Student> findByEnrollmentInYear(int year) {
		return em.createNamedQuery("Student.findByEnrollmentInYear", Student.class)
				.setParameter("year", year)
				.getResultList();
	}

	@Override
	public List<Student> findByEnrollmentInCourse(String title) {
		return em.createNamedQuery("Student.findStudentsEnrolledInCourse", Student.class)
				.setParameter("title", "%"+title+"%")
				.getResultList();
	}


}
