package soy.basic.vo;

import soy.basic.database.entity.BaseOrgan;

public class BaseOrganVO {
	private BaseOrgan baseOrgan;

	private Integer id;
	private String organName;
	private String organAddress;
	private String organContact;
	private String phoneTh1;
	private String phoneTh2;
	private String mobilePhoneTh1;
	private String mobilePhoneTh2;
	private String ramark;
	
	public BaseOrganVO() {}
	
	public BaseOrganVO(BaseOrgan baseOrgan) {
		this.baseOrgan = baseOrgan;
	}

	public BaseOrgan getBaseOrgan() {
		return baseOrgan;
	}

	public void setBaseOrgan(BaseOrgan baseOrgan) {
		this.baseOrgan = baseOrgan;
	}

	public Integer getId() {
		if (getBaseOrgan() != null &&  this.id == null) {
			this.id = getBaseOrgan().getId();
		}
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganName() {
		if (getBaseOrgan() != null && this.organName == null) {
			this.organName = getBaseOrgan().getOrganName();
		}
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getOrganAddress() {
		if (getBaseOrgan() != null && this.organAddress == null) {
			this.organAddress = getBaseOrgan().getOrganAddress();
		}
		return organAddress;
	}

	public void setOrganAddress(String organAddress) {
		this.organAddress = organAddress;
	}

	public String getOrganContact() {
		if (getBaseOrgan() != null && this.organContact == null) {
			this.organContact = getBaseOrgan().getOrganContact();
		}
		return organContact;
	}

	public void setOrganContact(String organContact) {
		this.organContact = organContact;
	}

	public String getPhoneTh1() {
		if (getBaseOrgan() != null && this.phoneTh1 == null) {
			this.phoneTh1 = getBaseOrgan().getPhoneTh1();
		}
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
		if (getBaseOrgan() != null && this.mobilePhoneTh1 == null) {
			this.mobilePhoneTh1 = getBaseOrgan().getMobilePhoneTh1();
		}
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

	public String getRamark() {
		if (getBaseOrgan() != null && this.ramark == null) {
			this.ramark = getBaseOrgan().getRamark();
		}
		return ramark;
	}

	public void setRamark(String ramark) {
		this.ramark = ramark;
	}

}
