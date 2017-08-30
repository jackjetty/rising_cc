package com.bhyf.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bhyf.service.interf.perm.PermService;


@Controller
public class IndexController {
	
	@Resource
	private PermService permService;
	
    @RequestMapping(value="/index")  
    public String index(HttpSession session, HttpServletRequest request, Model model) {
    	String menuHtml = permService.createBootstrapMenuByUserName(request);
		model.addAttribute("menuHtml", menuHtml);
        return "index.html";
    }


}
