package com.jsp.springmvc_student_socialprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc_student_socialprofile.entity.Student;
import com.jsp.springmvc_student_socialprofile.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/addStudent" ,method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute Student student) {
		return studentService.addStudent(student);
	}
	
	@RequestMapping(value = "/displayAllStudentDetails" )
	public ModelAndView displayStudents() {
		return studentService.displayStudents();
	}
	
	@RequestMapping(value = "/findAndLoadStudent")
	public ModelAndView findAndLoadStudent(@RequestParam int studentId) {
		return studentService.findAndLoadStudent(studentId);
	}
	
	@RequestMapping(value = "/Update",method = RequestMethod.POST)
	public ModelAndView updateStudent(Student student) {
		return studentService.updateStudent(student);
	}
	@RequestMapping(value = "/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int studentId) {
		return studentService.deleteStudent(studentId);
	}
	
}
