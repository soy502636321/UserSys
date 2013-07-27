package soy.basic.dao;

import java.util.List;

public interface SysRoleDAO extends BaseDAO {
	public List findByName(String name);
}
