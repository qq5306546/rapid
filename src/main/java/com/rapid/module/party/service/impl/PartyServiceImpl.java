package com.rapid.module.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.core.base.service.BaseServiceImpl;
import com.rapid.core.plugin.config.SystemGlobal;
import com.rapid.module.party.model.Party;
import com.rapid.module.party.service.PartyService;
import com.rapid.module.party.service.PartyTypeService;

@Service
public class PartyServiceImpl extends BaseServiceImpl<Party, String> implements PartyService {
	
	@Autowired
	private SystemGlobal systemGlobal;
	@Autowired
	private PartyTypeService partyTypeService;

	public int createParty(Party party) {
		return 0;
	}
}
