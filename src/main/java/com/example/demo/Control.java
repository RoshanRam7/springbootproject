package com.example.demo;

import java.util.Optional;
import java.util.Scanner;

import javax.swing.text.View;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class Control {
			
	@Autowired
	Studentrepo repo;
	
	@RequestMapping("home")
	public String home()
	{
		return "home";
	}
	//STORING DATA
	//METHOD 1
	@GetMapping("storedata")
	public ModelAndView store(@RequestParam ("name") String namee, @RequestParam("rollno") int rollnoo, @RequestParam("email") String emaill)
	{
		Student ss=new Student();
		 ss.setName(namee);
		 ss.setRollno(rollnoo);
		 ss.setEmail(emaill);
		 
		 repo.save(ss);
		 
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("obj",ss);
		 mv.setViewName("view");
		 return mv;
	}
	

	@RequestMapping("alldetails")
	@ResponseBody
	public String alldetails()
	{
		return repo.findAll().toString();
	}
	@RequestMapping("detailsform")
    public String detailsform()
    {
		return "detailsform";
    }
	@RequestMapping("deleteform")
	public String delete()
	{
		return "deleteform";
	}
	/*@GetMapping("getdetails")
	@ResponseBody
	public String getdetails(@RequestParam("rollno") int r)
	{
		
		return repo.findById(r).toString();
	}*/
	@GetMapping("getdetails")
	@ResponseBody
	public ModelAndView getdetails(@RequestParam("rollno") int r)
	{
		Optional<Student> ss=repo.findById(r);
		Student ss2=ss.get();
		ModelAndView mv=new ModelAndView();
		mv.addObject("obj2",ss2);
		mv.setViewName("view2");
		return mv;
	}
	//for postman 
	@DeleteMapping("delete")
	public ModelAndView delete(@RequestParam ("rollno") int r)
	{
		Optional<Student> ss=repo.findById(r);
		Student ss3=ss.get();
		ModelAndView mv=new ModelAndView();
		mv.addObject("obj3",ss3);
		mv.setViewName("view3");
		repo.deleteById(r);
		return mv;
		
	}
	//For browser mode
	@GetMapping("delete")
	public ModelAndView delete2(@RequestParam ("rollno") int r)
	{
		Optional<Student> ss=repo.findById(r);
		Student ss3=ss.get();
		ModelAndView mv=new ModelAndView();
		mv.addObject("obj3",ss3);
		mv.setViewName("view3");
		repo.deleteById(r);
		return mv;
		
	}
	
}
