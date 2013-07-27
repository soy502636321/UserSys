package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSysRole entity provides the base persistence definition of the
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSysRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private String remark;
	private Set sysRoleFunctions = new HashSet(0);
	private Set sysUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSysRole() {
	}

	/** full constructor */
	public AbstractSysRole(String roleName, String remark,
			Set sysRoleFunctions, Set sysUsers) {
		this.roleName = roleName;
		this.remark = remark;
		this.sysRoleFunctions = sysRoleFunctions;
		this.sysUsers = sysUsers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSysRoleFunctions() {
		return this.sysRoleFunctions;
	}

	public void setSysRoleFunctions(Set sysRoleFunctions) {
		this.sysRoleFunctions = sysRoleFunctions;
	}

	public Set getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set sysUsers) {
		this.sysUsers = sysUsers;
	}

}