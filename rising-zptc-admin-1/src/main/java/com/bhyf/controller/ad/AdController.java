package com.bhyf.controller.ad;

import java.util.HashMap;

import com.bhyf.model.ad.Ad;
import com.bhyf.pojo.qo.ad.AdQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.rising.common.component.BaseController;
import com.rising.common.component.PaginQo;
import com.rising.common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bhyf.service.interf.ad.AdService;



@Controller
@RequestMapping("/ad")
public class AdController extends BaseController{
	
	@Autowired
	AdService adService;
	
	@RequestMapping("/to_ad_list")
	public ModelAndView rollManagerPage(){
		ModelAndView view = new ModelAndView("/ad/ad.html");
		return view;
	}

	@RequestMapping("/ad_list")
	@ResponseBody
	public DataGridResponse getRollManagerList(
											   @RequestParam(value="page",required=true) Integer pageNo,
											   @RequestParam(value="rows",required=true) Integer pageSize,
											   @ModelAttribute AdQo qo
											   ) {
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);

		Pagination pagination = this.createPagination(paginQo,qo);
		pagination = adService.getRollManagerList(pagination);
		return new DataGridResponse(pagination);
	}
	
	@RequestMapping("/addRollImg")
	public @ResponseBody
	HashMap<String, Object> addRollImg(String origImageLinkUrl,String targImageLinkUrl,String adName,String status,Integer sortNum) {
		Ad rm = new Ad();
		rm.setTargImageLinkUrl(targImageLinkUrl);rm.setAdName(adName);rm.setStatus(status);rm.setSortNum(sortNum);
		String imageFilePath = adService.handleImg(origImageLinkUrl);
		rm.setOrigImageLinkUrl(imageFilePath);
		return adService.addRollImg(rm);
	}
	
	
	@RequestMapping("/editRollImg")
	public @ResponseBody
	HashMap<String, Object> editRollImg(String id,String origImageLinkUrl,String targImageLinkUrl,String adName,String status,Integer sortNum) {
		Ad rm = new Ad();
		rm.setTargImageLinkUrl(targImageLinkUrl);rm.setAdName(adName);rm.setSortNum(sortNum);
		rm.setId(id);rm.setStatus(status);
		String reg = "viewImages?picPath=";
		String imageFilePath = null ;
		if(origImageLinkUrl.indexOf(reg) > -1){
			String s[] = origImageLinkUrl.split("=");
			origImageLinkUrl = s[s.length-1];
			imageFilePath = origImageLinkUrl;
		}else{
			imageFilePath = adService.handleImg(origImageLinkUrl);
			
		}
		rm.setOrigImageLinkUrl(imageFilePath);
		return adService.editRollImg(rm);
	}
	
	@RequestMapping("/deleteRollImg")
	public @ResponseBody
	HashMap<String, Object> deleteRollImg(String id) {
		return adService.deleteRollImg(id);
	}
	
	@RequestMapping("/changeStatus")
	public @ResponseBody HashMap<String, Object> changeStatus(String id,String status) {
		HashMap<String, Object> result = adService.changeStatus(id,status);
		return result;
	}
}
