package soy.basic.database.entity;

import java.util.Set;

/**
 * BaseOrgan entity. @author MyEclipse Persistence Tools
 */
public class BaseOrgan extends AbstractBaseOrgan implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public BaseOrgan() {
	}

	/** full constructor */
	public BaseOrgan(String organName, String organAddress, String ramark,
			Set sysWorkers) {
		super(organName, organAddress, ramark, sysWorkers);
	}

}
