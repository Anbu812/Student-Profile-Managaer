package com.jsp.springmvc_student_socialprofile.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jsp.springmvc_student_socialprofile.entity.SocialProfile;
import com.jsp.springmvc_student_socialprofile.entity.Student;

@Repository
public class SocialProfileRepository {

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		return emf.createEntityManager();
	}

	public void addSocialProfile(SocialProfile socialProfile) {
		EntityManager em = SocialProfileRepository.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(socialProfile);

		et.commit();
		em.close();

	}

	public SocialProfile findSocialProfile(int socialProfileId) {
		EntityManager em = SocialProfileRepository.getEntityManager();

		SocialProfile socialProfile = em.find(SocialProfile.class,socialProfileId);
		
		em.close();
		return socialProfile;
	}

	public void updateSocialProfile(SocialProfile socialProfile) {
		EntityManager em = SocialProfileRepository.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.merge(socialProfile);

		et.commit();
		em.close();
	}

	public void remove(int socialProfileId) {
		EntityManager em = SocialProfileRepository.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		SocialProfile socialProfile=em.find(SocialProfile.class,socialProfileId);
		em.remove(socialProfile);
		
		et.commit();
		em.close();
	}

}
