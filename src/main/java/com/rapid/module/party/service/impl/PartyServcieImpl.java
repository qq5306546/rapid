package com.rapid.module.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.core.base.service.BaseServiceImpl;
import com.rapid.core.plugin.config.SystemGlobal;
import com.rapid.core.utils.StringUtil;
import com.rapid.module.party.model.Party;
import com.rapid.module.party.service.PartyOperService;
import com.rapid.module.party.service.PartyService;
import com.rapid.module.party.service.PartyTypeService;

@Service
public class PartyServcieImpl extends BaseServiceImpl<Party, String> implements PartyService {
	
	@Autowired
	private PartyTypeService partyTypeService;
	@Autowired
	private SystemGlobal global;

	@Override
	public int createParty(Party party) {
		String parentTypeId = partyTypeService.selectParentId(party.getPartyTypeId());
		
		// 保存当事人对象
		insert(party);
		
		// 反射获得具体保存子对象的实现
		String beanName = StringUtil.toCamelCase(parentTypeId) + "ServiceImpl";
		PartyOperService operService = (PartyOperService) global.getBean(beanName);
		// 保存子对象
		operService.createPartyChildren(party);
		return 0;
	}


}
