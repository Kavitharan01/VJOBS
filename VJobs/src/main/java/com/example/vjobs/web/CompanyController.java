package com.example.vjobs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.vjobs.model.Company;
import com.example.vjobs.repository.CompanyRepository;

@Controller
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/companee")
	public ModelAndView showCompanee() {
		ModelAndView mav = new ModelAndView("companee");
		List<Company> list = companyRepository.findAll();
		mav.addObject("company",list);
		return mav;
	}
	
	@GetMapping("/addcompanee")
	public ModelAndView addCompany() {
		  ModelAndView mav = new ModelAndView("addcompanee"); 
		  Company newCompany = new Company();
		  mav.addObject("companee",newCompany); 
		  return mav;	
	}
	
	@PostMapping("/saveCompany")
	public String saveCompany(@ModelAttribute Company company) {
	    companyRepository.save(company);
	    return "redirect:/companylist";
	}
	

	 @GetMapping("/companylist")
	    public String listCompany(Model model) {
	        List<Company> company = companyRepository.findAll();
	        model.addAttribute("company", company);
	        return "companylist";
	    }
	 
	 @GetMapping("/showCompanyUpdateForm")
	 public ModelAndView showCompanyUpdateForm(@RequestParam Long companyId) {
		 ModelAndView mav = new ModelAndView("addcompanee"); 
		 Company company  = companyRepository.findById(companyId).get();
		 mav.addObject("companee",company);
		 return mav;
	 }
	 
	 @GetMapping("/deleteCompany")
	 public String deleteCompany(@RequestParam Long companyId) {
		 companyRepository.deleteById(companyId);
		 return "redirect:/companylist";
	 }
}
