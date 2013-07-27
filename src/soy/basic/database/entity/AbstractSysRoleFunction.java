package soy.basic.database.entity;

/**
 * AbstractSysRoleFunction entity provides the base persistence definition of
 * the SysRoleFunction entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSysRoleFunction implements java.io.Serializable {

	// Fields

	private SysRoleFunctionId id;

	// Constructors

	/** default constructor */
	public AbstractSysRoleFunction() {
	}

	/** full constructor */
	public AbstractSysRoleFunction(SysRoleFunctionId id) {
		this.id = id;
	}

	// Property accessors

	public SysRoleFunctionId getId() {
		return this.id;
	}

	public void setId(SysRoleFunctionId id) {
		this.id = id;
	}

}