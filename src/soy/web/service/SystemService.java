package soy.web.service;

import java.util.List;

import soy.basic.database.entity.BaseOrgan;
import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysRole;


public interface SystemService {

	// 系统功能
	public List<SysFunction> findAllSysFunction();

	public List<SysFunction> findFunctionByName(String functionName);

	public SysFunction findFunctionById(String id);

	public void saveFunction(SysFunction obj);

	// 系统角色
	public List<SysRole> findAllSysRole();

	public List<SysRole> findRoleByName(String roleName);

	public SysRole findRoleById(String id);

	public void saveRole(Object obj);

	// 系统角色功能
	public List<SysFunction> findFunctionByRoleCode(String code);

	public void saveRoleFunction(List<SysFunction> functionList,
			String sectionCode);

}