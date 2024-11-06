package com.jsp.springmvc_student_socialprofile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc_student_socialprofile.entity.SocialProfile;
import com.jsp.springmvc_student_socialprofile.entity.Student;
import com.jsp.springmvc_student_socialprofile.repository.SocialProfileRepository;
import com.jsp.springmvc_student_socialprofile.repository.StudentRepository;

@Service
public class SocialProfileService {

	@Autowired
	private SocialProfileRepository socialProfileRepository;

	@Autowired
	private StudentRepository studentRepository;

	public ModelAndView addSocialProfile(int studentId, SocialProfile socialProfile) 
	{
		Student student = studentRepository.findStudent(studentId);
		socialProfile.setStudent(student);
		socialProfileRepository.addSocialProfile(socialProfile);

		student.getProfiles().add(socialProfile);
		studentRepository.updateStudent(student);

		return new ModelAndView("DisplayAllSocialProfile");
	}

	public ModelAndView displaySocialProfiles(int studentId) 
	{
		Student student = studentRepository.findStudent(studentId);
		List<SocialProfile> profiles = student.getProfiles();

		ModelAndView mav = new ModelAndView("DisplayAllSocialProfile.jsp");
		mav.addObject("studentId", studentId);
		mav.addObject("listOfProfiles", profiles);

		return mav;
	}

	public ModelAndView showSocialProfile(int socialProfileId, int studentId) 
	{
		SocialProfile socialProfile = socialProfileRepository.findSocialProfile(socialProfileId);

		ModelAndView mav = new ModelAndView("updateSocialProfile.jsp");
		mav.addObject("Socialprofile", socialProfile);
		mav.addObject("studentId", studentId);

		return mav;
	}

	public ModelAndView updateSocialProfile(int studentId, SocialProfile socialProfile) 
	{
		Student student = studentRepository.findStudent(studentId);
		socialProfile.setStudent(student);

		System.out.println(student.hashCode());

		socialProfileRepository.updateSocialProfile(socialProfile);

		Student student1 = studentRepository.findStudent(studentId);
		List<SocialProfile> profiles = student1.getProfiles();

		return new ModelAndView("DisplayAllSocialProfile.jsp").addObject("studentId", studentId)
				.addObject("listOfProfiles", profiles);

	}

	public ModelAndView deleteSocialProfile(int studentId, int socialProfileId) 
	{
		socialProfileRepository.remove(socialProfileId);

		Student student1 = studentRepository.findStudent(studentId);
		List<SocialProfile> profiles = student1.getProfiles();

		return new ModelAndView("DisplayAllSocialProfile.jsp").addObject("studentId", studentId)
				.addObject("listOfProfiles", profiles);

	}
}
