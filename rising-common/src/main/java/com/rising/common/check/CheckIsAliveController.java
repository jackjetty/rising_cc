package com.rising.common.check;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckIsAliveController {
	
	@RequestMapping("/isalive")
	@ResponseBody
	public String alive(){
		return "yes";
	}
}
