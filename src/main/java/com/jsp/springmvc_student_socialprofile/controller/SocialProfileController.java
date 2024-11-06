package com.jsp.springmvc_student_socialprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc_student_socialprofile.entity.SocialProfile;
import com.jsp.springmvc_student_socialprofile.service.SocialProfileService;

@Controller
public class SocialProfileController {

	@Autowired
	private SocialProfileService socialProfileService;
	
	@RequestMapping(value = "/AddSocialProfile")
	public ModelAndView addSocialProfile(@RequestParam int studentId,SocialProfile socialProfile) {
		return socialProfileService.addSocialProfile(studentId,socialProfile);
	}
	
	@RequestMapping(value = "/DisplayAllSocialProfile")
	public ModelAndView displaySocialProfiles(@RequestParam int studentId) {
		return socialProfileService.displaySocialProfiles(studentId);
	}
	
	@RequestMapping(value = "/showSocialProfile")
	public ModelAndView showSocialProfile(@RequestParam int socialProfileId,@RequestParam int studentId) {	
		return socialProfileService.showSocialProfile(socialProfileId,studentId);
	}
	@RequestMapping(value = "/updateSocialProfile")
	public ModelAndView updateSocialProfile(@RequestParam int studentId,SocialProfile socialProfile) {	
		return socialProfileService.updateSocialProfile(studentId,socialProfile);
	}
	@RequestMapping(value = "/deleteSocialProfile")
	public ModelAndView deleteSocialProfile(@RequestParam int studentId,@RequestParam int socialProfileId) {
		return socialProfileService.deleteSocialProfile(studentId,socialProfileId);
	}
}
