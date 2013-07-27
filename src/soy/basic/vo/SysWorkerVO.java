package soy.basic.vo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseAccount;
import soy.basic.database.entity.BaseEducational;
import soy.basic.database.entity.BaseOrgan;
import soy.basic.database.entity.SysUser;
import soy.basic.database.entity.SysWorker;
import soy.util.DateUtil;
import soy.util.SystemUtil;


public class SysWorkerVO {
	private static final Logger log = LoggerFactory
			.getLogger(SysWorkerVO.class);

	private SysWorker sysWorker;

	private String id;
	private BaseOrgan baseOrgan;
	private Integer baseOrganId;
	private String baseOrganName;

	private BaseEducational baseEducational;
	private Integer baseEducationalId;
	private String baseEducationalName;

	private SysUser sysUser;

	private BaseAccount baseAccount;
	private Integer baseAccountId;
	private String baseAccountName;

	private String name;
	private String gender;
	private Integer genderId;
	private boolean isMan = true;
	private boolean isWoman;

	private Date birthday;
	private String birthdayStr;

	private String idCard;
	private String address;
	private String passport;
	private Date outDate;
	private String outDateStr;

	private Date inDate;
	private String inDateStr;

	private Date insureDate;
	private String insureDateStr;

	private String record;
	private Integer recordId;
	private String remark;
	private Date operatingTime;

	public SysWorkerVO() {
	}

	public SysWorkerVO(SysWorker sysWorker) {
		this.sysWorker = sysWorker;
	}

	public SysWorker getSysWorker() {
		return sysWorker;
	}

	public void setSysWorker(SysWorker sysWorker) {
		this.sysWorker = sysWorker;
	}

	public String getId() {
		if (getSysWorker() != null && id == null) {
			this.id = String.valueOf(getSysWorker().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseOrgan getBaseOrgan() {
		return baseOrgan;
	}

	public void setBaseOrgan(BaseOrgan baseOrgan) {
		this.baseOrgan = baseOrgan;
	}

	public BaseEducational getBaseEducational() {
		return baseEducational;
	}

	public void setBaseEducational(BaseEducational baseEducational) {
		this.baseEducational = baseEducational;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public BaseAccount getBaseAccount() {
		return baseAccount;
	}

	public void setBaseAccount(BaseAccount baseAccount) {
		this.baseAccount = baseAccount;
	}

	public String getName() {
		if (getSysWorker() != null && name == null) {
			this.name = getSysWorker().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		if (getSysWorker() != null && gender == null) {
			if (getSysWorker().getGender().intValue() == 0) {
				this.gender = "女";
			} else {
				this.gender = "男";
			}
		}
		return gender;
	}

	public void setGender(String gender) {
		if (gender != null && "1".equals(gender)) {
			setGenderId(new Integer(1));
		} else if (gender != null && "0".equals(gender)) {
			setGenderId(new Integer(new Integer(0)));
		}
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		if (getSysWorker() != null && this.idCard == null) {
			this.idCard = getSysWorker().getIdCard();
		}
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddress() {
		if (getSysWorker() != null && this.address == null) {
			this.address = getSysWorker().getAddress();
		}
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassport() {
		if (getSysWorker() != null && this.passport == null) {
			this.passport = getSysWorker().getPassport();
		}
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getInsureDate() {
		return insureDate;
	}

	public void setInsureDate(Date insureDate) {
		this.insureDate = insureDate;
	}

	public String getRecord() {
		if (getSysWorker() != null && this.record == null) {
			if (SystemUtil.isYes(getSysWorker().getRecord())) {
				this.record = "是";
			} else {
				this.record = "否";
			}
		}
		return record;
	}

	public void setRecord(String record) {
		if (record != null && "1".equals(record)) {
			setRecordId(new Integer(1));
		} else {
			setRecordId(new Integer(0));
		}
		this.record = record;
	}

	public String getRemark() {
		if (getSysWorker() != null && this.remark == null) {
			this.remark = getSysWorker().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(Date operatingTime) {
		this.operatingTime = operatingTime;
	}

	public String getBaseOrganName() {
		if (getSysWorker() != null && this.baseOrganName == null) {
			this.baseOrganName = getSysWorker().getBaseOrgan().getOrganName();
		}
		return baseOrganName;
	}

	public void setBaseOrganName(String baseOrganName) {
		this.baseOrganName = baseOrganName;
	}

	public String getBirthdayStr() {
		if (getSysWorker() != null && this.birthdayStr == null
				&& getSysWorker().getBirthday() != null) {
			this.birthdayStr = DateUtil.getDate(getSysWorker().getBirthday());
		}
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		setBirthday(DateUtil.getDate(birthdayStr));
		this.birthdayStr = birthdayStr;
	}

	public String getOutDateStr() {
		if (getSysWorker() != null && this.outDateStr == null
				&& getSysWorker().getOutDate() != null) {
			this.outDateStr = DateUtil.getDate(getSysWorker().getOutDate());
		}
		return outDateStr;
	}

	public void setOutDateStr(String outDateStr) {
		if (outDateStr != null && outDateStr.trim().length() == 11) {
			setOutDate(DateUtil.getDate(outDateStr));
		}
		this.outDateStr = outDateStr;
	}

	public String getInDateStr() {
		if (getSysWorker() != null && this.inDateStr == null
				&& getSysWorker().getInDate() != null) {
			this.inDateStr = DateUtil.getDate(getSysWorker().getInDate());
		}
		return inDateStr;
	}

	public void setInDateStr(String inDateStr) {
		if (inDateStr != null && inDateStr.trim().length() == 11) {
			setInDate(DateUtil.getDate(inDateStr));
		}
		this.inDateStr = inDateStr;
	}

	public String getInsureDateStr() {
		if (getSysWorker() != null && this.insureDate == null
				&& this.getSysWorker().getInsureDate() != null) {
			this.insureDateStr = DateUtil.getDate(getSysWorker()
					.getInsureDate());
		}
		return insureDateStr;
	}

	public void setInsureDateStr(String insureDateStr) {
		if (insureDateStr != null && insureDateStr.trim().length() == 11) {
			setInsureDate(DateUtil.getDate(insureDateStr));
		}
		this.insureDateStr = insureDateStr;
	}

	public String getBaseAccountName() {
		if (getSysWorker() != null && this.baseAccountName == null) {
			this.baseAccountName = getSysWorker().getBaseAccount()
					.getAccountName();
		}
		return baseAccountName;
	}

	public void setBaseAccountName(String baseAccountName) {
		this.baseAccountName = baseAccountName;
	}

	public String getBaseEducationalName() {
		if (getSysWorker() != null && this.baseEducationalName == null) {
			this.baseEducationalName = getSysWorker().getBaseEducational()
					.getEducationalName();
		}
		return baseEducationalName;
	}

	public void setBaseEducationalName(String baseEducationalName) {
		this.baseEducationalName = baseEducationalName;
	}

	public Integer getBaseOrganId() {
		return baseOrganId;
	}

	public void setBaseOrganId(Integer baseOrganId) {
		this.baseOrganId = baseOrganId;
	}

	public Integer getBaseAccountId() {
		return baseAccountId;
	}

	public void setBaseAccountId(Integer baseAccountId) {
		this.baseAccountId = baseAccountId;
	}

	public Integer getBaseEducationalId() {
		return baseEducationalId;
	}

	public void setBaseEducationalId(Integer baseEducationalId) {
		this.baseEducationalId = baseEducationalId;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public boolean isMan() {
		System.out.println("是否是个男的？");
		getGender();
		if ("男".equals(this.gender)) {
			this.isMan = true;
		}
		System.out.println("OKOKOKKOOKKO");
		return isMan;
	}

	public void setMan(boolean isMan) {
		this.isMan = isMan;
	}

	public boolean isWoman() {
		getGender();
		if ("女".equals(this.gender)) {
			return true;
		}
		return false;
	}

	public void setWoman(boolean isWoman) {
		this.isWoman = isWoman;
	}

}
