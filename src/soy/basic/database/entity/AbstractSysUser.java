package soy.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSysUser entity provides the base persistence definition of the
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSysUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysRole sysRole;
	private String username;
	private String password;
	private String name;
	private Integer gender;
	private String phoneTh1;
	private String phoneTh2;
	private String emailTh1;
	private String emailTh2;
	private Integer userState;
	private String remark;
	private Set sysWorkers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSysUser() {
	}

	/** minimal constructor */
	public AbstractSysUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public AbstractSysUser(SysRole sysRole, String username, String password,
			String name, Integer gender, String phoneTh1, String phoneTh2,
			String emailTh1, String emailTh2, Integer userState, String remark,
			Set sysWorkers) {
		this.sysRole = sysRole;
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phoneTh1 = phoneTh1;
		this.phoneTh2 = phoneTh2;
		this.emailTh1 = emailTh1;
		this.emailTh2 = emailTh2;
		this.userState = userState;
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

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhoneTh1() {
		return this.phoneTh1;
	}

	public void setPhoneTh1(String phoneTh1) {
		this.phoneTh1 = phoneTh1;
	}

	public String getPhoneTh2() {
		return this.phoneTh2;
	}

	public void setPhoneTh2(String phoneTh2) {
		this.phoneTh2 = phoneTh2;
	}

	public String getEmailTh1() {
		return this.emailTh1;
	}

	public void setEmailTh1(String emailTh1) {
		this.emailTh1 = emailTh1;
	}

	public String getEmailTh2() {
		return this.emailTh2;
	}

	public void setEmailTh2(String emailTh2) {
		this.emailTh2 = emailTh2;
	}

	public Integer getUserState() {
		return this.userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
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