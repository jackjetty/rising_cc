package com.rising.cc.model.basicdata;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.basicdata.redis.CreateRedisCommand;
import com.rising.cc.pojo.command.basicdata.redis.UpdateRedisCommand;

@SuppressWarnings("serial")
public class SysRedisInfo extends BaseModel{
	/** redis地址 */
	private String url;
	/** redis端口*/
	private String port;
	/** redis用户名*/
	private String userName;
	/** redis密码*/
	private String password;
	/** reids说明*/
	private String description;
	/** redis类型 0:本地开发库，1：本地测试库，2：预发布库，3：生产库 */
	private Integer type;
	/** redis超时时间 */
	private Integer timeout;
	/** redis最大空闲数 */
	private Integer maxIdle;
	/**  redis最小空闲数 */
	private Integer minIdle;
	/** redis连接池的最大数据库连接数 */
	private Integer maxActive;
	/** redis最大建立连接等待时间 */
	private Integer maxWait;
	/** 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的 */
	private boolean testOnBorrow;
	/** 在return给pool时，是否提前进行validate操作 */
	private boolean testOnReturn;
	/** 如果为true，表示有一个idle object 
	 * evitor线程对idle object进行扫描，如果validate失败，
	 * 此object会被从pool中drop掉；
	 * 这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义*/
	private boolean testWhileIdle;
	/** 状态 0:禁用;1:启用;80:删除 */
	private Integer status;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	public Integer getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}
	public Integer getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}
	public Integer getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(Integer maxWait) {
		this.maxWait = maxWait;
	}
		
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public boolean getTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public boolean getTestWhileIdle() {
		return testWhileIdle;
	}
	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public void createSysRedisInfo(String url, String port, String userName, String password,
			String description, Integer type, Integer timeout,Integer maxIdle,Integer minIdle,
			Integer maxActive,Integer maxWait,boolean testOnBorrow,boolean testOnReturn,
			boolean testWhileIdle){
		this.url =url;
		this.port = port;
		this.userName = userName;
		this.password = password;
		this.description = description;
		this.type = type;
		this.timeout = timeout;
		this.maxIdle = maxIdle;
		this.minIdle = minIdle;
		this.maxActive = maxActive;
		this.maxWait = maxWait;
		this.testOnBorrow = testOnBorrow;
		this.testOnReturn = testOnReturn;
		this.testWhileIdle = testWhileIdle;
	}
	
	public void createRedis(CreateRedisCommand command){
		if(command != null){
			this.url = command.getUrl();
			this.port = command.getPort();
			this.userName = command.getUserName();
			this.password = command.getPassword();
			this.description = command.getDescription();
			this.type = command.getType();
			this.timeout = command.getTimeout();
			this.maxIdle = command.getMaxIdle();
			this.minIdle = command.getMinIdle();
			this.maxActive = command.getMaxActive();
			this.maxWait = command.getMaxWait();
			this.testOnBorrow = command.getTestOnBorrow();
			this.testOnReturn = command.getTestOnReturn();
			this.testWhileIdle = command.getTestWhileIdle();
			this.status = command.getStatus();
		}
	}
	
	public void updateRedis(UpdateRedisCommand command){
		if(command != null){
			super.setId(command.getRedisId());
			this.url = command.getUrl();
			this.port = command.getPort();
			this.userName = command.getUserName();
			this.password = command.getPassword();
			this.description = command.getDescription();
			this.type = command.getType();
			this.timeout = command.getTimeout();
			this.maxIdle = command.getMaxIdle();
			this.minIdle = command.getMinIdle();
			this.maxActive = command.getMaxActive();
			this.maxWait = command.getMaxWait();
			this.testOnBorrow = command.getTestOnBorrow();
			this.testOnReturn = command.getTestOnReturn();
			this.testWhileIdle = command.getTestWhileIdle();
			this.status = command.getStatus();
		}
	}
}
