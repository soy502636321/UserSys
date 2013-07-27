package soy.web.service;

import java.util.List;

import soy.basic.vo.SysUserVO;
import soy.common.displaytag.SimplePaginatedList;


public interface UserService {
	public SysUserVO login(SysUserVO sysUserVO);
	
	public List findSysFunctionAll();
	
	public SimplePaginatedList find(SimplePaginatedList paginatedList, SysUserVO sysUserVO);
}
