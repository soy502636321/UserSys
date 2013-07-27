package soy.basic.dao;

import java.util.List;

import soy.basic.vo.SysUserVO;
import soy.common.displaytag.SimplePaginatedList;


public interface SysUserDAO extends BaseDAO {
	public List findByUsername(String username);
	
	public SimplePaginatedList find(SimplePaginatedList paginatedList, SysUserVO sysUserVO);
}
