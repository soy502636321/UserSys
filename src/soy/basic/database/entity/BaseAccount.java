package soy.basic.database.entity;

import java.util.Set;

/**
 * BaseAccount entity. @author MyEclipse Persistence Tools
 */
public class BaseAccount extends AbstractBaseAccount implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public BaseAccount() {
	}

	/** full constructor */
	public BaseAccount(String accountName, String remark, Set sysWorkers) {
		super(accountName, remark, sysWorkers);
	}

}
