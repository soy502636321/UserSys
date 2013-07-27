package soy.basic.dao;

import java.util.List;

public interface SysRoleFunctionDAO extends BaseDAO {
	public List findByRoleCode(String code);
}
