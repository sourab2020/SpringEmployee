package com.concretepage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import com.concretepage.entity.Employee;
import com.concretepage.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	
	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private LocaleResolver localeResolver;
	
	@RequestMapping(value="employeeform")
	public ModelAndView user(){
		ModelAndView mv = new ModelAndView("employeeform","employee",new Employee());
		setPageData(mv.getModelMap());
		return mv;
	}
	
	@RequestMapping(value="addPerson", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("employee") @Valid Employee employee, BindingResult result, 
			ModelMap model, HttpServletRequest request) {
	    if(!result.hasErrors()) {
	    	boolean flag = service.addEmployee(employee);
	    	if (flag) {
				model.addAttribute(new Employee());
				model.addAttribute("msg", getMsg("person.added", request));
	    	} else {
	    		model.addAttribute("msg", getMsg("person.duplicate", request));
	    	}
	    }
	    setPageData(model);
		return "employeeform";
	}
	@RequestMapping(value="personById")
	public String getPersonById(ModelMap model, HttpServletRequest request) {
		int pid = Integer.parseInt(request.getParameter("id"));
		Employee employee = service.getEmployeeById(pid);
		setPageData(model);
		model.addAttribute(employee);		
		return "employeeform";
	}
	
	@RequestMapping(value="updatePerson", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute("employee") @Valid Employee employee, BindingResult result,
			ModelMap model, HttpServletRequest request) {
		if(!result.hasErrors()) {
			service.updateEmployee(employee);
			model.addAttribute(new Employee());
			model.addAttribute("msg", getMsg("person.updated", request));
		}
		setPageData(model);
		return "employeeform";
	}	
	@RequestMapping(value="deletePerson")
	public String deletePerson(ModelMap model, HttpServletRequest request) {
		int pid = Integer.parseInt(request.getParameter("id"));
		service.deleteEmployee(pid);
		model.addAttribute(new Employee());
		model.addAttribute("msg", getMsg("person.deleted", request));
		setPageData(model);
		return "employeeform";
	}
	
	

	private String getMsg(String key, HttpServletRequest request) {
		return messageSource.getMessage(key, null, localeResolver.resolveLocale(request));
	}

	private void setPageData(ModelMap model) {
		model.addAttribute("allData", service.getallEmployees());
		model.addAttribute("genderOptions", Employee.getGenderOptions());
	
	}

}
