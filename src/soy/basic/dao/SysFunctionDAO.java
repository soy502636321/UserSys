package soy.basic.dao;

import java.util.List;

public interface SysFunctionDAO extends BaseDAO {
	public List findByName(String value);
}
