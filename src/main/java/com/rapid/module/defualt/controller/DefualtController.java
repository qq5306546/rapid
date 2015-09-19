package com.rapid.module.defualt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rapid.core.base.controller.BaseController;

@Controller
@RequestMapping("/admin")
public class DefualtController extends BaseController {
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return render("defualt/index");
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		System.out.println("1111");
		return render("defualt/home");
	}
}
