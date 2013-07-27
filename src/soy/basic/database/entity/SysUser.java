package soy.basic.database.entity;

import java.util.Set;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */
public class SysUser extends AbstractSysUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String username, String password) {
		super(username, password);
	}

	/** full constructor */
	public SysUser(SysRole sysRole, String username, String password,
			String name, Integer gender, String phoneTh1, String phoneTh2,
			String emailTh1, String emailTh2, Integer userState, String remark,
			Set sysWorkers) {
		super(sysRole, username, password, name, gender, phoneTh1, phoneTh2,
				emailTh1, emailTh2, userState, remark, sysWorkers);
	}

}
