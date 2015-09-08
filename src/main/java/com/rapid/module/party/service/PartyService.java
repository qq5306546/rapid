package com.rapid.module.party.service;

import com.rapid.core.base.service.BaseService;
import com.rapid.module.party.model.Party;

/**
 * 当事人Service
 * @author wubei
 *
 */
public interface PartyService extends BaseService<Party, String> {

	/**
	 * 创建一个当事人
	 * @param 
	 * 		party
	 * @return
	 */
	public int createParty(Party party);
}
