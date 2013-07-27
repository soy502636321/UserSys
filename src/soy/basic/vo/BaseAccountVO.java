package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseAccount;

public class BaseAccountVO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseAccountVO.class);
	private BaseAccount baseAccount;
	private String id;
	private String accountName;
	private String remark;
	
	public BaseAccountVO(){}
	
	public BaseAccountVO(BaseAccount baseAccount) {
		this.baseAccount = baseAccount;
	}

	public BaseAccount getBaseAccount() {
		return baseAccount;
	}

	public void setBaseAccount(BaseAccount baseAccount) {
		this.baseAccount = baseAccount;
	}

	public String getId() {
		if (getBaseAccount() != null && this.id == null) {
			this.id = String.valueOf(getBaseAccount().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountName() {
		if (getBaseAccount() != null && this.accountName == null) {
			this.accountName = getBaseAccount().getAccountName();
		}
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRemark() {
		if (getBaseAccount() != null && this.remark == null) {
			this.remark = getBaseAccount().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
