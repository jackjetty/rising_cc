package com.rising.cc.auth;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rising.cc.model.perm.SysPermission;
import com.rising.cc.service.interf.perm.PermService;
import com.rising.common.util.Md5Util;

/**
 * 
 * @description 加载权限资源
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午3:52:49
 *
 */
public class MyFilterChainDefinitionsLoader {
	
	private static final Logger logger = LoggerFactory.getLogger(MyFilterChainDefinitionsLoader.class);

	@Autowired
	private PermService permService;
	
	private AbstractShiroFilter shiroFilter;
	
	public synchronized void loadShiroFilterMap(){
		
		logger.info("-------------加载访问资源和权限-------------");
		
		try {
			
			PathMatchingFilterChainResolver chainResolver=(PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
			
			logger.info("getFilterChainResolver:" + chainResolver);
			
			DefaultFilterChainManager chainManager=(DefaultFilterChainManager) chainResolver.getFilterChainManager();
			
			logger.info("getFilterChainManager:" + chainManager);
			
			//-------------加载访问资源和权限-------------//
			List<SysPermission> permAllList=permService.findAllSysPerm();
			
			logger.info("findAllPerms:" + permAllList.size());
			
			for(SysPermission perm : permAllList){
				if(perm != null && StringUtils.isNotBlank(perm.getPermUrl())){
					if(perm.getPermUrl().indexOf("?")>0){
						//dfcm.createChain(perm.getUrl().substring(0, perm.getUrl().indexOf("?")), "authc,perms["+MD5HashUtil.toMD5(perm.getUrl())+"]");
						chainManager.createChain(perm.getPermUrl().substring(0, perm.getPermUrl().indexOf("?")), "authc,perms["+Md5Util.MD5(perm.getPermUrl().substring(0, perm.getPermUrl().indexOf("?")))+"]");
					}else{
						chainManager.createChain(perm.getPermUrl(), "authc,perms["+Md5Util.MD5(perm.getPermUrl())+"]");
					}
				}
			}
			logger.info("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AbstractShiroFilter getShiroFilter() {
		return shiroFilter;
	}

	public void setShiroFilter(AbstractShiroFilter shiroFilter) {
		this.shiroFilter = shiroFilter;
	}

	
	public void init(){
		//另开一个线程，防止容器启动时卡在加载方法这。
		Thread thread=new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				loadShiroFilterMap();
				
			}
		});
		thread.start();
	}
}
