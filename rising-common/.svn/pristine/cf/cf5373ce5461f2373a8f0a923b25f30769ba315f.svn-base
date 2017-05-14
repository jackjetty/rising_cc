package com.rising.common.cache.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import com.rising.common.cache.model.CommonCache;
import com.rising.common.cache.qo.CommonCacheQo;

/**
 * 
 * <p>Title : CommonCacheManager</p>
 * <p>Description : 缓存管理器</p>
 * <p>Company : 杭州冉思科技有限公司</p>
 * @author : caoyang
 * @date : 2016年3月30日 上午10:08:47
 */
@Component
public class CommonCacheManager {
	
	@Autowired(required=false)
	protected RedisTemplate<String, String> redisTemplate;
	
	public boolean setCommonCache(final CommonCache cache) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {
            	RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            	byte [] key = serializer.serialize(cache.getKeyPrefix()+":"+cache.getKey());
            	byte [] value = serializer.serialize(cache.getValue());
            	if(cache.getExpireSecond() == null){
            		connection.set(key, value);
            	}else{
            		connection.setEx(key, cache.getExpireSecond(), value);
            	}
				return true;
            }
        }, false, true);  
        return result;  
    }
	
	public String getCommonCacheValue(final CommonCacheQo qo) {
		String value = redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)  
					throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte [] value = connection.get(serializer.serialize(qo.getKeyPrefix()+":"+qo.getKey()));
				if(value == null){
					return null;
				}
				return new String(value);
			}
		});
		return value;  
	}
	
    
}
