package com.rapid.module.party.service;

import com.rapid.core.base.service.BaseService;
import com.rapid.module.party.model.PartyType;


/**
 * 当事人类型Service
 * @author wubei
 *
 */
public interface PartyTypeService extends BaseService<PartyType, String> {

	/**
	 * 通过当事人类型子节点标识查找父节点<br>
	 * 如果上级节点has_table为N时，则递归查找<br>
	 * 上级节点has_table为Y时，则返回该节点的partyTypeId
	 * @param 
	 * 		partyTypeId 当事人类型唯一标识
	 * @return
	 * 		String 当事人类型标识
	 */
	public String selectParentId(String partyTypeId);
}
