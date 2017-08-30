package com.bhyf.dao.ad;

import java.util.ArrayList;
import java.util.HashMap;

import com.bhyf.model.ad.Ad;
import com.rising.common.page.Pagination;

public interface AdDao {

	ArrayList<Ad> getRollManagerList(Pagination pagination);
	
	void addRollImg(Ad rm);
	
	void editRollImg(Ad rm);
	
	void deleteRollImg(ArrayList<String> ai);
	
	void changeStatus(HashMap<String, Object> map);
	
	Integer getRollManagerListCount(Pagination pagination);
	
	ArrayList<Ad> getRollImgs();
	
	Integer getRollImgsCount();
}
