package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractBaseOrgan entity provides the base persistence definition of the
 * BaseOrgan entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBaseOrgan implements java.io.Serializable {

	// Fields

	private Integer id;
	private String organName;
	private String organAddress;
	private String organContact;
	private String phoneTh1;
	private String phoneTh2;
	private String mobilePhoneTh1;
	private String mobilePhoneTh2;
	private String ramark;
	private Set sysWorkers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBaseOrgan() {
	}

	/** full constructor */
	public AbstractBaseOrgan(String organName, String organAddress,
			String ramark, Set sysWorkers) {
		this.organName = organName;
		this.organAddress = organAddress;
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

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getOrganAddress() {
		return this.organAddress;
	}

	public void setOrganAddress(String organAddress) {
		this.organAddress = organAddress;
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

	public String getOrganContact() {
		return organContact;
	}

	public void setOrganContact(String organContact) {
		this.organContact = organContact;
	}

	public String getPhoneTh1() {
		return phoneTh1;
	}

	public void setPhoneTh1(String phoneTh1) {
		this.phoneTh1 = phoneTh1;
	}

	public String getPhoneTh2() {
		return phoneTh2;
	}

	public void setPhoneTh2(String phoneTh2) {
		this.phoneTh2 = phoneTh2;
	}

	public String getMobilePhoneTh1() {
		return mobilePhoneTh1;
	}

	public void setMobilePhoneTh1(String mobilePhoneTh1) {
		this.mobilePhoneTh1 = mobilePhoneTh1;
	}

	public String getMobilePhoneTh2() {
		return mobilePhoneTh2;
	}

	public void setMobilePhoneTh2(String mobilePhoneTh2) {
		this.mobilePhoneTh2 = mobilePhoneTh2;
	}

}