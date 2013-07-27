package soy.basic.database.entity;

/**
 * SysRoleFunctionId entity. @author MyEclipse Persistence Tools
 */
public class SysRoleFunctionId extends AbstractSysRoleFunctionId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SysRoleFunctionId() {
	}

	/** full constructor */
	public SysRoleFunctionId(SysRole sysRole, SysFunction sysFunction) {
		super(sysRole, sysFunction);
	}

}
