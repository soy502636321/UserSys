package soy.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.SysFunctionDAO;
import soy.basic.dao.SysUserDAO;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.SysUserVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.SystemUtil;
import soy.web.service.UserService;


public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory
			.getLogger(UserServiceImpl.class);

	private SysFunctionDAO sysFunctionDAO;
	private SysUserDAO sysUserDAO;

	@Override
	public SysUserVO login(SysUserVO sysUserVO) {
		if (!SystemUtil.isEmpty(sysUserVO)) {
			List list = sysUserDAO.findByUsername(sysUserVO.getUsername());
			if (!SystemUtil.isNull(list)) {
				return new SysUserVO((SysUser) list.get(0));
			}
		}
		return null;
	}

	@Override
	public List findSysFunctionAll() {
		return getSysFunctionDAO().findAll();
	}

	public SysFunctionDAO getSysFunctionDAO() {
		return sysFunctionDAO;
	}

	public void setSysFunctionDAO(SysFunctionDAO sysFunctionDAO) {
		this.sysFunctionDAO = sysFunctionDAO;
	}

	public SysUserDAO getSysUserDAO() {
		return sysUserDAO;
	}

	public void setSysUserDAO(SysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}

	@Override
	public SimplePaginatedList find(SimplePaginatedList paginatedList,
			SysUserVO sysUserVO) {
		paginatedList = getSysUserDAO().find(paginatedList, sysUserVO);
		List<SysUser> sysUsers = paginatedList.getList();
		List vos = new ArrayList();
		for (SysUser sysUser : sysUsers) {
			vos.add(new SysUserVO(sysUser));
		}
		paginatedList.setList(vos);
		return paginatedList;
	}

}
