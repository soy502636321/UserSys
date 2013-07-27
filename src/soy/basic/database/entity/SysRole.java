package soy.basic.database.entity;

import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */
public class SysRole extends AbstractSysRole implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** full constructor */
	public SysRole(String roleName, String remark, Set sysRoleFunctions,
			Set sysUsers) {
		super(roleName, remark, sysRoleFunctions, sysUsers);
	}

}
