package com.rising.common.cache.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>Title : HashCommonCacheManager</p>
 * <p>Description : Hash缓存管理器</p>
 * <p>Company : 杭州冉思科技有限公司</p>
 * @author : caoyang
 * @date : 2016年6月29日 下午5:19:41
 */
@Component
public class CommonHashCacheManager {
	
	@Autowired(required=false)
	protected RedisTemplate<String, String> redisTemplate;
	
	/**
	 * 
	 * <p>Description : 批量设置Hash缓存</p>
	 * @author : caoyang
	 * @date : 2016年6月29日 下午5:21:27
	 * @param key
	 * @param valueMap
	 * @return
	 */
	public boolean batchSetCache(final String key, final Map<String, String> valueMap) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {
            	 BoundHashOperations<String, String, String> boundHashOperations = 
            			 redisTemplate.boundHashOps(key);
                boundHashOperations.putAll(valueMap);
				return true;
            }  
        });  
        return result;  
    }
	
	public boolean singleSetCache(final String key, final String field, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {
            	 BoundHashOperations<String, String, String> boundHashOperations = 
            			 redisTemplate.boundHashOps(key);
            	 boundHashOperations.put(field, value);
				return true;
            }
        });  
        return result;  
    }
	
    public boolean deleteCache(final String key, final String field) {
    	boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {
            	 BoundHashOperations<String, String, String> boundHashOperations = 
            			 redisTemplate.boundHashOps(key);
            	 
            	 boundHashOperations.delete(field);
				return true;
            }
        }); 
    	return result;
    }  
    
    public String getCache(final String key, final String field) {
    	String value = redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)  
                    throws DataAccessException {
            	BoundHashOperations<String, String, String> boundHashOperations = 
            			redisTemplate.boundHashOps(key);
            	
            	String value = boundHashOperations.get(field);
            	
            	return value;
            }
        }); 
    	return value;
    }
    
    
}
