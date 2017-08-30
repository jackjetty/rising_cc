package com.bhyf.controller.enter;

import com.alibaba.fastjson.JSON;
import com.bhyf.common.component.BaseController;
import com.bhyf.common.component.PaginQo;
import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.command.enter.*;
import com.bhyf.pojo.command.user.*;
import com.bhyf.pojo.constants.role.RoleConstants;
import com.bhyf.pojo.dto.role.SysRoleDto;
import com.bhyf.pojo.exception.BusinessException;
import com.bhyf.pojo.qo.enter.EnterQo;
import com.bhyf.pojo.qo.role.RoleQo;
import com.bhyf.pojo.qo.user.UserQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.enter.EnterService;
import com.bhyf.service.interf.role.RoleService;
import com.bhyf.service.interf.user.UserService;
import com.rising.common.page.Pagination;
import com.rising.common.util.FileUtils;
import com.rising.common.util.JsonUtil;
import com.rising.common.util.PathUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description 用户管理控制器
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:45:44
 *
 */
@Controller
@RequestMapping("/enter")
public class EnterController extends BaseController{

	public static final long maxFileSize = 2 * 1024 * 1024; // 文件上传的最大字节
	@Resource
	private EnterService enterService;
	




	
	/**
	 * 
	 * @description 跳转用户列表
	 * @author caoy
	 * @date 2015年8月11日 上午10:41:08
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("to_enter_list")
	public String toEnterList(HttpServletRequest request,
			Model model){

		return "/enter/enter.html";
	}

	/**
	 * 
	 * @description 加载用户列表
	 * @author caoy
	 * @date 2015年8月11日 上午10:41:08
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("enter_list")
	@ResponseBody
	public DataGridResponse findEnterList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute EnterQo qo,
			Model model){
		
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);


		pagination = enterService.findEnterByPagination(pagination);
		return new DataGridResponse(pagination);
	}

	@RequestMapping(value="/upload_file")
	@ResponseBody
	public String uploadFile(HttpServletRequest request,
												@RequestParam("uploadFile") MultipartFile uploadFile,
												Model model){



			String destFileName = uploadFile.getOriginalFilename();

			String fileName = "";
			File file = null;
			try {
				destFileName= FileUtils.getFileNameString(destFileName);//字符过滤
				destFileName=System.currentTimeMillis()+"_"+destFileName;
				file = new File(destFileName);
				uploadFile.transferTo(file);
				fileName = PathUtil.getRootPath()+"resources/enterPicture/"+destFileName;
				org.apache.commons.io.FileUtils.copyFile(file,new File(fileName));

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				try {
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("status", "success");
		map.put("fileName", destFileName);
		return JsonUtil.parseObject(map, false);
	}
	/**
	 *
	 * @description 加载用户列表
	 * @author caoy
	 * @date 2015年8月11日 上午10:41:08
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("save_enter")
	@ResponseBody
	public String saveEnter(HttpServletRequest request,
										 @ModelAttribute CreateEnterCommand command,
										 Model model){


		String str =  enterService.saveEnter(command);
		return str;
	}
	@RequestMapping("remove_enter")
	@ResponseBody
	public String removeEnter(HttpServletRequest request,
										 @ModelAttribute RemoveEnterCommand command,
										 Model model){


		String str =  enterService.removeEnter(command);
		return str;
	}
	@RequestMapping("update_enter")
	@ResponseBody
	public String updateEnter(HttpServletRequest request,
										 @ModelAttribute UpdateEnterCommand command,
										 Model model){


		String str =  enterService.updateEnter(command);
		return str;
	}
	@RequestMapping("update_enter_status")
	@ResponseBody
	public String updateEnterStatus(HttpServletRequest request,
										 @ModelAttribute UpdateEnterStatusCommand command,
										 Model model){


		String str =  enterService.updateEnterStatus(command);
		return str;
	}
}
