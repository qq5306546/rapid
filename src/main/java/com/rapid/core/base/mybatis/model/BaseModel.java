package com.rapid.core.base.mybatis.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 数据实体的基类
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class BaseModel implements Serializable {

	private Date createStamp; 		// 创建时间
	private Date lastUpdateStamp; 	// 最后修改时间
	
	public Date getCreateStamp() {
		return createStamp;
	}
	public void setCreateStamp(Date createStamp) {
		this.createStamp = createStamp;
	}
	public Date getLastUpdateStamp() {
		return lastUpdateStamp;
	}
	public void setLastUpdateStamp(Date lastUpdateStamp) {
		this.lastUpdateStamp = lastUpdateStamp;
	}
	
	
}
