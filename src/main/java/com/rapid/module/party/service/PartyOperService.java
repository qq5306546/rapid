package com.rapid.module.party.service;

import com.rapid.module.party.model.Party;

/**
 * 当事人对象操作Service
 * @author wubei
 *
 */
public interface PartyOperService {

	/**
	 * 创建一个具体的当事人类型，该方法由PartyService的createParty方法调用<br>
	 * Person 人员<br>
	 * PartyGroup 组织<br>
	 * xxx 任何party子类型<br>
	 * 不同类型的当事人如果有具体表结构来保存，则自定义实现PartyOperService的类<br>
	 * 详细实现可参考，PartyGroupServiceImpl、PersonServiceImpl
	 * @param 
	 * 		party 当事人对象
	 * @return
	 * 		int大于0则成功
	 */
	int createPartyChildren(Party party);
}
