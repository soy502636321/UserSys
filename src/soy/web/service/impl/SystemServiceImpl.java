package soy.web.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import soy.basic.dao.BaseOrganDAO;
import soy.basic.dao.SysFunctionDAO;
import soy.basic.dao.SysRoleDAO;
import soy.basic.dao.SysRoleFunctionDAO;
import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysRole;
import soy.basic.database.entity.SysRoleFunction;
import soy.basic.database.entity.SysRoleFunctionId;
import soy.web.service.SystemService;


/**
 * 系统管理模块的接口操作.
 * 
 * @author roger 2012-9-21
 * 
 */
public class SystemServiceImpl implements SystemService {

	private static final Logger log = LoggerFactory
			.getLogger(SystemServiceImpl.class);

	private SysRoleDAO sysRoleDAO;
	private SysFunctionDAO sysFunctionDAO;
	private SysRoleFunctionDAO sysRoleFunctionDAO;

	// 系统功能
	@Override
	public List<SysFunction> findAllSysFunction() {
		return sysFunctionDAO.findAll();
	}

	@Override
	public List<SysFunction> findFunctionByName(String functionName) {
		return sysFunctionDAO.findByName(functionName);
	}

	@Override
	public SysFunction findFunctionById(String id) {
		return (SysFunction) sysFunctionDAO.findById(id);
	}

	@Override
	public void saveFunction(SysFunction obj) {
		sysFunctionDAO.save(obj);
	}

	// 系统角色
	@Override
	public List<SysRole> findAllSysRole() {
		return sysRoleDAO.findAll();
	}

	@Override
	public List<SysRole> findRoleByName(String roleName) {
		return sysRoleDAO.findByName(roleName);
	}

	@Override
	public SysRole findRoleById(String id) {
		return (SysRole) sysRoleDAO.findById(id);
	}

	@Override
	public void saveRole(Object obj) {
		sysRoleDAO.save(obj);
	}

	// 系统角色功能
	@Override
	public List<SysFunction> findFunctionByRoleCode(String code) {
		List<SysRoleFunction> list = sysRoleFunctionDAO.findByRoleCode(code);
		List<SysFunction> functionList = new ArrayList<SysFunction>();
		for (SysRoleFunction roleFunction : list) {
			functionList.add(roleFunction.getId().getSysFunction());
		}
		System.out.println("功能数量：" + list.size());
		return functionList;
	}

	@Override
	public void saveRoleFunction(List<SysFunction> functionList, String roleCode) {

		// 获取 角色 对象
		SysRole role = findRoleById(roleCode);

		// 获取此 角色 原先 角色功能
		List<SysRoleFunction> sysRoleFunctionList = sysRoleFunctionDAO
				.findByRoleCode(roleCode);

		// 遍历新增加集合
		for (SysFunction sysFunction : functionList) {
			boolean isHave = false;
			// 如果原先数据库集合没有包含对象，刚要增加
			for (SysRoleFunction sysRoleFunction : sysRoleFunctionList) {
				if (sysRoleFunction.getId().getSysFunction().getId()
						.equals(sysFunction.getId())) {
					isHave = true;
					break;
				}
			}
			if (!isHave) {
				sysRoleFunctionDAO.save(new SysRoleFunction(
						new SysRoleFunctionId(role, sysFunction)));
			}
		}

		// 遍历数据库原先集合
		for (SysRoleFunction sysRoleFunction : sysRoleFunctionList) {

			boolean isHave = false;
			// 如果新增的没有包含了原先的对象，则要删除
			for (SysFunction sysFunction : functionList) {
				if (sysRoleFunction.getId().getSysFunction().getId()
						.equals(sysFunction.getId())) {
					isHave = true;
					break;
				}
			}
			if (!isHave) {
				sysRoleFunctionDAO.delete(sysRoleFunction);
			}
		}

	}

	public SysRoleDAO getSysRoleDAO() {
		return sysRoleDAO;
	}

	public void setSysRoleDAO(SysRoleDAO sysRoleDAO) {
		this.sysRoleDAO = sysRoleDAO;
	}

	public SysFunctionDAO getSysFunctionDAO() {
		return sysFunctionDAO;
	}

	public void setSysFunctionDAO(SysFunctionDAO sysFunctionDAO) {
		this.sysFunctionDAO = sysFunctionDAO;
	}

	public SysRoleFunctionDAO getSysRoleFunctionDAO() {
		return sysRoleFunctionDAO;
	}

	public void setSysRoleFunctionDAO(SysRoleFunctionDAO sysRoleFunctionDAO) {
		this.sysRoleFunctionDAO = sysRoleFunctionDAO;
	}

}
