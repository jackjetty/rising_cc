package com.rising.cc.common.component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.rising.cc.model.service.ServicesAndServer;

@SuppressWarnings("serial")
public class BaseQo implements Serializable{
	
	/**
	 * 检索组合方式；AND或OR
	 */

    private Integer id;

	private String groupOp;
	
	/**
	 * 检索键值；name:"张三"
	 */
	private List<Map<String,Object>> rules;
	
	/**
	 * 排序字段 ；name
	 */
	private String sidx;
	
	/**
	 * 排序方式；asc,desc
	 */
	private String sord;
	
	private String filters;

    private String spi;
	
	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
		
		BaseQo qo =JSONObject.parseObject(filters, BaseQo.class);
		
		this.groupOp = qo.getGroupOp();
		this.rules = qo.getRules();
		
	}

	public String getGroupOp() {
		return groupOp;
	}

	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}

	public List<Map<String, Object>> getRules() {
		return rules;
	}

	public void setRules(List<Map<String, Object>> rules) {
		this.rules = rules;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

    public Integer getId() {
        return id;
    }

    public String getSpi() {
        return spi;
    }

    public void setSpi(String spi) {
        this.spi = spi;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BaseQo(Integer id) {
        this.id = id;
    }

    public BaseQo() {
    }

    public void createSpi(ServicesAndServer servicesAndServer) {
        if(servicesAndServer !=null){
            setSpi("http://"+servicesAndServer.getServer().getIp()+":"+servicesAndServer.getPort());
        }
    }
}
