package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSysFunction entity provides the base persistence definition of the
 * SysFunction entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSysFunction implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysFunction sysFunction;
	private String functionName;
	private String functionUrl;
	private String functionType;
	private String remark;
	private Set sysRoleFunctions = new HashSet(0);
	private Set sysFunctions = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSysFunction() {
	}

	/** minimal constructor */
	public AbstractSysFunction(String functionName) {
		this.functionName = functionName;
	}

	/** full constructor */
	public AbstractSysFunction(SysFunction sysFunction, String functionName,
			String functionUrl, String functionType, String remark,
			Set sysRoleFunctions, Set sysFunctions) {
		this.sysFunction = sysFunction;
		this.functionName = functionName;
		this.functionUrl = functionUrl;
		this.functionType = functionType;
		this.remark = remark;
		this.sysRoleFunctions = sysRoleFunctions;
		this.sysFunctions = sysFunctions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysFunction getSysFunction() {
		return this.sysFunction;
	}

	public void setSysFunction(SysFunction sysFunction) {
		this.sysFunction = sysFunction;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public String getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
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

	public Set getSysFunctions() {
		return this.sysFunctions;
	}

	public void setSysFunctions(Set sysFunctions) {
		this.sysFunctions = sysFunctions;
	}

}