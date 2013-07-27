package soy.basic.database.entity;

import java.util.Date;

/**
 * AbstractSysWorker entity provides the base persistence definition of the
 * SysWorker entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSysWorker implements java.io.Serializable {

	// Fields

	private Integer id;
	private BaseOrgan baseOrgan;
	private BaseEducational baseEducational;
	private SysUser sysUser;
	private BaseAccount baseAccount;
	private String name;
	private Integer gender;
	private Date birthday;
	private String idCard;
	private String address;
	private String passport;
	private Date outDate;
	private Date inDate;
	private Date insureDate;
	private Integer record;
	private String remark;
	private Date operatingTime;

	// Constructors

	/** default constructor */
	public AbstractSysWorker() {
	}

	/** full constructor */
	public AbstractSysWorker(BaseOrgan baseOrgan,
			BaseEducational baseEducational, SysUser sysUser,
			BaseAccount baseAccount, String name, Integer gender,
			Date birthday, String idCard, String address, String passport,
			Date outDate, Date inDate, Date insureDate, Integer record,
			String remark, Date operatingTime) {
		this.baseOrgan = baseOrgan;
		this.baseEducational = baseEducational;
		this.sysUser = sysUser;
		this.baseAccount = baseAccount;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.idCard = idCard;
		this.address = address;
		this.passport = passport;
		this.outDate = outDate;
		this.inDate = inDate;
		this.insureDate = insureDate;
		this.record = record;
		this.remark = remark;
		this.operatingTime = operatingTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseOrgan getBaseOrgan() {
		return this.baseOrgan;
	}

	public void setBaseOrgan(BaseOrgan baseOrgan) {
		this.baseOrgan = baseOrgan;
	}

	public BaseEducational getBaseEducational() {
		return this.baseEducational;
	}

	public void setBaseEducational(BaseEducational baseEducational) {
		this.baseEducational = baseEducational;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public BaseAccount getBaseAccount() {
		return this.baseAccount;
	}

	public void setBaseAccount(BaseAccount baseAccount) {
		this.baseAccount = baseAccount;
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

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Date getOutDate() {
		return this.outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public Date getInDate() {
		return this.inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getInsureDate() {
		return this.insureDate;
	}

	public void setInsureDate(Date insureDate) {
		this.insureDate = insureDate;
	}

	public Integer getRecord() {
		return this.record;
	}

	public void setRecord(Integer record) {
		this.record = record;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOperatingTime() {
		return this.operatingTime;
	}

	public void setOperatingTime(Date operatingTime) {
		this.operatingTime = operatingTime;
	}

}