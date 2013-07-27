package soy.basic.dao;

import java.util.List;

public interface BaseDAO {
	
	//保存一条记录
	public void save(Object object);
	
	//删除一条记录
	public void delete(Object object);
	
	//根据Id来查询一条记录
	public Object findById(Object id);
	
	//根据指定的属性来查询记录
	public List findByProperty(String propertyName, Object value);
	
	//查询所有的记录
	public List findAll();
	
}
