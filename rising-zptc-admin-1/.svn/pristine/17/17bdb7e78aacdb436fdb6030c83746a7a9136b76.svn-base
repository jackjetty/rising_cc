package com.bhyf.common.component;

import java.util.List;

import com.bhyf.common.page.Pagination;

/**
 * 基础Dao
 * @author caoy
 *
 */
public interface BaseDao<T extends BaseModel,Qo extends BaseQo> {
	
	/**
	 * 保存对象
	 * @param entity
	 * @return
	 */
	public Integer save(T entity);
	
	/**
	 * 修改对象
	 * @param entity
	 * @return
	 */
	public Integer update(T entity);
	
	/**
	 * 根据ID物理删除对象
	 * @param id
	 * @return
	 */
	public Integer delete(String id);
	
	/**
	 * 根据ids 物理批量删除对象
	 * @param ids
	 * @return
	 */
	public Integer deleteBatch(List<String> ids);
	
	/**
	 * 根据ID逻辑删除对象，修改对象状态
	 * @param id
	 * @return
	 */
	public Integer remove(String id);
	
	/**
	 * 根据ids 逻辑批量删除对象，修改对象状态
	 * @param ids
	 * @return
	 */
	public Integer removeBatch(List<String> ids);
	
	/**
	 * 查询唯一对象
	 * @param qo
	 * @return
	 */
	public T queryUnique(Qo qo);
	
	/**
	 * 查询满足Qo条件的对象列表
	 * @param qo
	 * @return
	 */
	public List<T> queryList(Qo qo);
	
	/**
	 * 分页查询返回当前页的对象列表
	 * @param pagination
	 * @return
	 */
	public List<T> queryPagination(Pagination pagination);
	
	/**
	 * 分页统计总条数
	 * @param pagination
	 * @return
	 */
	public Integer countPagination(Pagination pagination);
	
}
