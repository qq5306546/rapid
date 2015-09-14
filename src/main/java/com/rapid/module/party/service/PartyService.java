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
	 * 创建一个当事人对象<br>
	 * Party对象可以是Person或PartyGroup或自定义对象，创建对象的类型由partyTypeId当事人类型决定<br>
	 * 例：partyTypeId等于Person则通过反射创建Person的Party对象，数据库则会保存Party，Person数据各一条
	 * @param 
	 * 		party 对象
	 * @return
	 * 		int 大于0则成功
	 */
	int createParty(Party party);
}
