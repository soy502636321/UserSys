package soy.basic.dao;

import java.util.List;


public interface BaseEnhanceDAO extends BaseDAO {
	
	public void delObjectByKey(Object obj);
	
	public Object findObjectByKey(Object obj);
	
	public List findObjectByName(String name);
	
}
