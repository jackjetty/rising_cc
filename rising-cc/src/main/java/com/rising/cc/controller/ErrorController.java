package com.rising.cc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")  
public class ErrorController {
	
    @RequestMapping(value="/404")  
    public String notFoundError( HttpServletRequest request, Model model) { 
    	
        return "/error/404.html";
    }
    
    @RequestMapping(value="/400")  
    public String bandingError( HttpServletRequest request, Model model) { 
    	
    	return "/error/400.html";
    }
    @RequestMapping(value="/500")  
    public String systemError( HttpServletRequest request, Model model) { 
    	
    	return "/error/500.html";
    }
}
