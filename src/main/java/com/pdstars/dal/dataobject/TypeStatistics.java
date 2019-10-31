package com.pdstars.dal.dataobject;

public class TypeStatistics extends BaseDO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1958977222500271065L;

	private Long typeId;
    
    private String typeName;
    
    private Integer count;
    
    private String statisticsDate;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(String statisticsDate) {
		this.statisticsDate = statisticsDate;
	}
    
    
}