package dao;

import java.util.List;

import entity.Student;

public interface StudentDao {
	
	public List<Student> findByEnrollmentInYear(int year);
	public List<Student> findByEnrollmentInCourse(String title);
	
}
