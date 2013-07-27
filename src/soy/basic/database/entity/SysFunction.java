package soy.basic.database.entity;

import java.util.Set;

/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 */
public class SysFunction extends AbstractSysFunction implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SysFunction() {
	}

	/** minimal constructor */
	public SysFunction(String functionName) {
		super(functionName);
	}

	/** full constructor */
	public SysFunction(SysFunction sysFunction, String functionName,
			String functionUrl, String functionType, String remark,
			Set sysRoleFunctions, Set sysFunctions) {
		super(sysFunction, functionName, functionUrl, functionType, remark,
				sysRoleFunctions, sysFunctions);
	}

}
