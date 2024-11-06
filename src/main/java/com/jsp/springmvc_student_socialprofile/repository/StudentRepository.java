package com.jsp.springmvc_student_socialprofile.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.jsp.springmvc_student_socialprofile.entity.Student;

@Repository
public class StudentRepository {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("mysql");
	
	public void addStudent(Student student) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
	
		et.begin();
		em.persist(student);
		et.commit();				

		em.close();
	}
	
	public List<Student> displayStudents() {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();

		
		et.begin();
		
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Student> cq=cb.createQuery(Student.class);
		Root<Student> root=cq.from(Student.class);
				
		Query q=em.createQuery(cq);
		
		
		List<Student> students=q.getResultList();
		
//		Query query=em.createQuery("select s from Student s");
//		
//		List<Student> students=query.getResultList();
		
		et.commit();
		
		em.close();
		
		return students;
	}
	
	public void updateStudent(Student student) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();

		
		et.begin();
		
		em.merge(student);
		
		et.commit();
		
		em.close();
		
	}
	
	public Student findStudent(int studentId) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();

		et.begin();
		
		Query query=em.createQuery("select s from Student s where studentId="+studentId);
		
		Student student=(Student) query.getSingleResult();
		
		et.commit();
		
		em.close();
		
		return student;
	}

	public void deleteStudents(Student student) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();

		et.begin();
		
		em.remove(student);
		
		et.commit();
		
		em.close();
	}
}
