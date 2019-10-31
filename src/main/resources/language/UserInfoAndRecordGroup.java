package com.pdstars.dal.dataobject;

public class UserInfoAndRecordGroup extends BaseDO {
	private static final long serialVersionUID = 5393742041842088968L;

	private Integer id;

	private Integer userinfoid;

	private Integer recordgroupid;

	private String recordGroupName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserinfoid() {
		return userinfoid;
	}

	public void setUserinfoid(Integer userinfoid) {
		this.userinfoid = userinfoid;
	}

	public Integer getRecordgroupid() {
		return recordgroupid;
	}

	public void setRecordgroupid(Integer recordgroupid) {
		this.recordgroupid = recordgroupid;
	}

	public String getRecordGroupName() {
		return recordGroupName;
	}

	public void setRecordGroupName(String recordGroupName) {
		this.recordGroupName = recordGroupName;
	}

}
