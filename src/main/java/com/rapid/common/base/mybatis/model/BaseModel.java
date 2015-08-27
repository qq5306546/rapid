package com.rapid.common.base.mybatis.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 数据实体的基类
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class BaseModel implements Serializable {

	private Date createTime; 		// 创建时间
	private Date lastUpdateTime; 	// 最后修改时间
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
}
