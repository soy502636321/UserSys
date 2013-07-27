package soy.basic.database.entity;

import java.util.Set;

/**
 * BaseEducational entity. @author MyEclipse Persistence Tools
 */
public class BaseEducational extends AbstractBaseEducational implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public BaseEducational() {
	}

	/** full constructor */
	public BaseEducational(String educationalName, String ramark, Set sysWorkers) {
		super(educationalName, ramark, sysWorkers);
	}

}
