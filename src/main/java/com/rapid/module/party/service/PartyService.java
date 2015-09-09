package com.rapid.module.party.service;

import com.rapid.module.party.model.Party;

/**
 * 当事人Service
 * @author wubei
 *
 */
public interface PartyService {

	/**
	 * 创建一个当事人对象<br>
	 * Party对象可以是Person或PartyGroup子类<br>
	 * @param 
	 * 		party 对象
	 * @return
	 * 		int 大于0则成功
	 */
	int createParty(Party party);
}
