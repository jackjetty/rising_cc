package com.bhyf.common.component;

import java.util.List;

import com.bhyf.common.page.Pagination;

/**
 * 基础查询接口
 * @author caoy
 *
 * @param <T>
 * @param <Qo>
 */
public interface BaseService<T extends BaseModel, Qo extends BaseQo> {
	
	/**
	 * 查询唯一实体
	 * @param qo
	 * @return
	 */
	public T queryUnique(Qo qo);
	
	/**
	 * 查询实体列表
	 * @param qo
	 * @return
	 */
	public List<T> queryList(Qo qo);
	
	/**
	 * 分页查询实体
	 * @param pagination
	 * @return
	 */
	public Pagination queryPagination(Pagination pagination);
	
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public Boolean save(T entity);
	
	/**
	 * 批量保存实体
	 * 
	 * @param entitys
	 */
	public Boolean saveBatch(List<T> entitys);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public Boolean update(T entity);
	
	/**
	 * 批量更新实体
	 * 
	 * @param entity
	 */
	public Boolean updateBatch(List<T> entitys);

	/**
	 * 根据ID删除实体
	 * 
	 * @param id
	 */
	public Boolean deleteById(String id);
	
	/**
	 * 根据ID数组批量删除实体
	 * @param id
	 */
	public Boolean deleteByIds(List<String> ids);

}
