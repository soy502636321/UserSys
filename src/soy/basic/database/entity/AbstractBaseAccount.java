package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBaseAccount implements java.io.Serializable {

	// Fields

	private Integer id; //户口类型Id
	private String accountName; //户口类型名字
	private String remark;//备注
	private Set sysWorkers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBaseAccount() {
	}

	/** full constructor */
	public AbstractBaseAccount(String accountName, String remark, Set sysWorkers) {
		this.accountName = accountName;
		this.remark = remark;
		this.sysWorkers = sysWorkers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSysWorkers() {
		return this.sysWorkers;
	}

	public void setSysWorkers(Set sysWorkers) {
		this.sysWorkers = sysWorkers;
	}

}