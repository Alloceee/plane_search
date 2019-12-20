package com.yws.plane.common.dynamicquery;
/**
 * 扩展SpringDataJpa, 支持动态jpql/nativesql查询并支持分页查询
 * 使用方法：注入ServiceImpl
 * 创建者 张志朋
 * 创建时间	2018年3月8日
 */
public interface DynamicQuery {

	public void save(Object entity);

	public void update(Object entity);

	public <T> void delete(Class<T> entityClass, Object entityid);

	public <T> void delete(Class<T> entityClass, Object[] entityids);
	
	/**
	 * 执行nativeSql统计查询
	 * @param nativeSql
	 * @param params 占位符参数(例如?1)绑定的参数值
	 * @return 统计条数
	 */
	Long nativeQueryCount(String nativeSql, Object... params);


}
