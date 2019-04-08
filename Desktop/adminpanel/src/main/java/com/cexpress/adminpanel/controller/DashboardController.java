package com.cexpress.adminpanel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DashboardController {
	@RequestMapping(value={"/", "/home"},method = RequestMethod.GET)
    public ModelAndView  home() {
    	
        ModelAndView mv = new ModelAndView("dashboard");
        
        
        return mv;
    }

}
