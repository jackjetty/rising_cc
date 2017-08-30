package com.bhyf.controller.vip;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bhyf.pojo.vip.Suggest;
import com.bhyf.service.interf.vip.SuggestService;

@Controller("suggestAction")
@RequestMapping("/suggest")
public class SuggestAction {

	@Autowired
	SuggestService suggestService;
	
	@RequestMapping("/doSuggest")
	public ModelAndView doEmployment(){
		ModelAndView view = new ModelAndView("/vip/doSuggest.html");
		return view;
	}
	
	
	@RequestMapping("/findSuggestById")
	public @ResponseBody
	Suggest findSuggestById(Integer id) {
		return suggestService.findSuggestById(id);
	}
	
	@RequestMapping("/getSuggestList")
	public @ResponseBody
	HashMap<String, Object> getSuggestList(String contactWay, String userName, String startTime, String endTime,
			Integer pageSize, Integer pageIndex) {
		HashMap<String, Object> resultMap = suggestService.getSuggestList(contactWay, userName, startTime, endTime, pageSize, pageIndex);
		return resultMap;
	}
	
	@RequestMapping("/exportDaInfo")
	public void exportDaInfo(String contactWay, String userName, String startTime, String endTime, HttpServletResponse response){
		suggestService.exportData(contactWay, userName, startTime, endTime, response);
    }
}
