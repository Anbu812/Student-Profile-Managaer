package com.jsp.springmvc_student_socialprofile.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;

@Entity
@Scope("prototype")
public class Student {

	@Id
	private int studentId;     
	private String studentName;     
	private String studentEmail;     
	private int studentMarks;
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentMarks=" + studentMarks + ", profiles=" + profiles + "]";
	}
	@OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
	private List<SocialProfile> profiles;
	
	public List<SocialProfile> getProfiles() {
		return profiles;
	}
	public void setProfiles(List<SocialProfile> profiles) {
		this.profiles = profiles;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public int getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}     
	
}
