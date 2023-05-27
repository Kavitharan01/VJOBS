package com.example.vjobs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.vjobs.model.Addjob;
import com.example.vjobs.repository.AddjobRepository;

@Controller
public class AddjobController {
	@Autowired
	private AddjobRepository addjobRepository;

	@GetMapping("/jobpage")
	public ModelAndView showjob() {
		ModelAndView mav = new ModelAndView("jobpage");
		List<Addjob> list = addjobRepository.findAll();
		mav.addObject("jobs", list);
		return mav;
	}

	@GetMapping("/addjob")
	public ModelAndView addjob() {
		ModelAndView mav = new ModelAndView("addjob");
		Addjob newJob= new Addjob();
		mav.addObject("job", newJob);
		return mav;
	}

	@PostMapping("/saveJob")
	public String saveJob(@ModelAttribute Addjob addjob) {
	    addjobRepository.save(addjob);
	    return "redirect:/jobpage";
	}
}
