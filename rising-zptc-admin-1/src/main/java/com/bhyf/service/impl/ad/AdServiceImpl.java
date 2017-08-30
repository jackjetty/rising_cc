package com.bhyf.service.impl.ad;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.bhyf.model.ad.Ad;
import com.rising.common.page.Pagination;
import com.rising.common.util.PathUtil;
import com.rising.common.util.PropertiesUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;

import com.bhyf.dao.ad.AdDao;
import com.bhyf.service.interf.ad.AdService;
import com.bhyf.util.CommonUtil;
import com.bhyf.util.ImageUtil;

import javax.annotation.Resource;

@Service()
public class AdServiceImpl implements AdService {
	Log log = LogFactory.getLog(AdServiceImpl.class);
	
	@Resource
	AdDao adDao;
	
	@Override
	public Pagination getRollManagerList(Pagination pagination) {
		Integer listSize = adDao.getRollManagerListCount(pagination);
		ArrayList<Ad> lists = adDao.getRollManagerList(pagination);
		pagination.setList(lists);
		pagination.setTotalCount(listSize);
		return pagination;
	}
	
	@Override
	public HashMap<String, Object> addRollImg(Ad cm){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		if(cm != null){
			try {
				adDao.addRollImg(cm);
				resultMap.put("success", "添加成功！");
			} catch (Exception e) {
				resultMap.put("error", "添加失败！");
			}
		}else{
			resultMap.put("error", "实例对象不能为空！");
		}
		return resultMap;
	}
	
	@Override
	public HashMap<String, Object> editRollImg(Ad cm){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		if(cm != null){
			try {
				adDao.editRollImg(cm);
				resultMap.put("success", "编辑成功！");
			} catch (Exception e) {
				resultMap.put("error", "编辑失败！");
			}
		}else{
			resultMap.put("error", "实例对象不能为空！");
		}
		return resultMap;
	}
	@Override
	public HashMap<String, Object> deleteRollImg(String id){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		if(StringUtils.hasLength(id)){
			try {
				ArrayList<String> ai = new ArrayList<String>();
				String[] ids = id.split(",");
				for (String id1 : ids) {
					try {
						ai.add(id1);
					} catch (Exception e) {
						continue;
					}
				}
				
				adDao.deleteRollImg(ai);
				resultMap.put("success", "删除成功！");
			} catch (Exception e) {
				resultMap.put("error", "删除出错！");
			}
		}else{
			resultMap.put("error", "ID不能为空！");
		}
		return resultMap;
	}
	
	public static HashMap<String, ArrayList<Ad>> roll = new HashMap<String, ArrayList<Ad>>();
	
	//@Cacheable(value="cache1")
	@Override
	public ArrayList<Ad> getRollImgs() {
		/*ArrayList<Ad> rolls = roll.get("rolls");
		ArrayList<Ad> lists = null;
		if(rolls == null){
			lists = adDao.getRollImgs();
			roll.put("rolls", lists);
		}else{
			Integer count = adDao.getRollImgsCount();
			if(rolls.size() == count){
				lists = roll.get("rolls");
			}else{
				lists = adDao.getRollImgs();
			}
		}*/
		 
		 return adDao.getRollImgs();
	}
	
	@Override
	public HashMap<String, Object> changeStatus(String id,String status) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		try {
				param.put("status", status);
			adDao.changeStatus(param);
			resultMap.put("success", "修改状态成功！");
		} catch (Exception e) {
			resultMap.put("error", "修改状态失败！");
		}
		return resultMap;
	}
	

	private Boolean base64StringToImageFile(String imgStr, String target)  
    {  if (imgStr == null) // 图像数据为空
   	 return false;
    BASE64Decoder decoder = new BASE64Decoder();
    try {
    // Base64解码
    byte[] b = decoder.decodeBuffer(imgStr);
    for (int i = 0; i < b.length; ++i) {
    if (b[i] < 0) {// 调整异常数据
    b[i] += 256;
    }
    }
    // 生成jpeg图片
    OutputStream os = new FileOutputStream(target);
    os.write(b);
    os.flush();
    os.close();
    return true;
    } catch (Exception e) {
    return false;
    }
    }
	private static Properties properties= PropertiesUtils.getProps("/properties/other.properties");
	@Override
	public String handleImg(String imgUrl){
		String picName = System.currentTimeMillis() + ".png";
		String imageFilePath = "";
		imageFilePath = PathUtil.getRootPath()+"resources/adPicture/";
		imageFilePath += CommonUtil.getDateForm();
		File fold = new File(imageFilePath);
		if (!fold.exists()) {
			fold.mkdirs();
		}
		imageFilePath += "/";
		imageFilePath += picName;
		String imageString = imgUrl;
		imageString = imageString.replace("data:image/jpeg;base64,", "");
		imageString = imageString.replace("data:image/jpg;base64,", "");
		imageString = imageString.replace("data:image/png;base64,", "");
		imageString = imageString.replace(" ", "+");
		base64StringToImageFile(imageString, imageFilePath);
		Boolean result = base64StringToImageFile(imageString, imageFilePath);
		if(result == true){
			imageFilePath = ImageUtil.getInstance().thumbnailImage(imageFilePath,400,209);
		}
		imageFilePath = imageFilePath.replaceAll("\\\\","\\/");
		imageFilePath = imageFilePath.substring(imageFilePath.indexOf("adPicture")+10,imageFilePath.length());
		return properties.getProperty("ad_picture_path")+imageFilePath;
	}
}
