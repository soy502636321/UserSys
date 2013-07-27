package soy.basic.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseEducational;

public class BaseEducationalVO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseEducationalVO.class);
	private BaseEducational baseEducational;
	private String id;
	private String educationalName;
	private String ramark;
	
	public BaseEducationalVO() {}
	
	public BaseEducationalVO(BaseEducational baseEducational) {
		this.baseEducational = baseEducational;
	}

	public BaseEducational getBaseEducational() {
		return baseEducational;
	}

	public void setBaseEducational(BaseEducational baseEducational) {
		this.baseEducational = baseEducational;
	}

	public String getId() {
		if (getBaseEducational() != null && this.id == null) {
			this.id = String.valueOf(getBaseEducational().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEducationalName() {
		if (getBaseEducational() != null && this.educationalName == null) {
			this.educationalName = getBaseEducational().getEducationalName();
		}
		return educationalName;
	}

	public void setEducationalName(String educationalName) {
		this.educationalName = educationalName;
	}

	public String getRamark() {
		if (getBaseEducational() != null && this.ramark == null) {
			this.ramark = getBaseEducational().getRamark();
		}
		return ramark;
	}

	public void setRamark(String ramark) {
		this.ramark = ramark;
	}

}
