package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class PageController{
	@RequestMapping("/viral")
	public String index(){
		return "viral";
	}
	
	@RequestMapping("/challengeLama")
	public String challenge(@RequestParam(value="name", required=false, defaultValue="kiki") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping({"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping({"/generator"})
	public String generator(@RequestParam(value="a", defaultValue="0") int a, @RequestParam(value="b", defaultValue="0") int b, String hm, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		String hmmAwal = "hm";
		String hasil = "";
		
		for (int i=0; i<a; i++) {
			hmmAwal += "m";
		}
		
		for (int j=0; j<b; j++) {
			hasil += hmmAwal + " ";
		}
		
		if (hasil=="") {
			model.addAttribute("hm","hm");
		}
		else {
			model.addAttribute("hm",hasil);
		}
		
		return "generator";
	}
}
