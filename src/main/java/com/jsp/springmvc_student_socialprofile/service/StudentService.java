package com.jsp.springmvc_student_socialprofile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc_student_socialprofile.entity.Student;
import com.jsp.springmvc_student_socialprofile.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public ModelAndView addStudent(Student student) {
		studentRepository.addStudent(student);
		return new ModelAndView("index.jsp");
	}

	public ModelAndView displayStudents() {
		List<Student> students=studentRepository.displayStudents();
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("displayStudents.jsp");
		mav.addObject("list",students);
		
		return mav;
	}
	public ModelAndView findAndLoadStudent(int studentId) {
		
		Student student=studentRepository.findStudent(studentId);
		
		studentRepository.updateStudent(student);
		
		return new ModelAndView("UpdateStudent.jsp").addObject("Student",student);
	}
	
	public ModelAndView updateStudent(Student student) {
		studentRepository.updateStudent(student);
		return new ModelAndView("displayAllStudentDetails");
	}

	public ModelAndView deleteStudent(int studentId) {
		Student student=studentRepository.findStudent(studentId);
		studentRepository.deleteStudents(student);
		return new ModelAndView("displayAllStudentDetails");
	}
}
