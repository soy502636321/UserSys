package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractBaseEducational entity provides the base persistence definition of
 * the BaseEducational entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBaseEducational implements java.io.Serializable {

	// Fields

	private Integer id;
	private String educationalName;
	private String ramark;
	private Set sysWorkers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBaseEducational() {
	}

	/** full constructor */
	public AbstractBaseEducational(String educationalName, String ramark,
			Set sysWorkers) {
		this.educationalName = educationalName;
		this.ramark = ramark;
		this.sysWorkers = sysWorkers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEducationalName() {
		return this.educationalName;
	}

	public void setEducationalName(String educationalName) {
		this.educationalName = educationalName;
	}

	public String getRamark() {
		return this.ramark;
	}

	public void setRamark(String ramark) {
		this.ramark = ramark;
	}

	public Set getSysWorkers() {
		return this.sysWorkers;
	}

	public void setSysWorkers(Set sysWorkers) {
		this.sysWorkers = sysWorkers;
	}

}