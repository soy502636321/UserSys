package soy.basic.database.entity;

import java.util.Date;

/**
 * SysWorker entity. @author MyEclipse Persistence Tools
 */
public class SysWorker extends AbstractSysWorker implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SysWorker() {
	}

	/** full constructor */
	public SysWorker(BaseOrgan baseOrgan, BaseEducational baseEducational,
			SysUser sysUser, BaseAccount baseAccount, String name,
			Integer gender, Date birthday, String idCard, String address,
			String passport, Date outDate, Date inDate, Date insureDate,
			Integer record, String remark, Date operatingTime) {
		super(baseOrgan, baseEducational, sysUser, baseAccount, name, gender,
				birthday, idCard, address, passport, outDate, inDate,
				insureDate, record, remark, operatingTime);
	}

}
