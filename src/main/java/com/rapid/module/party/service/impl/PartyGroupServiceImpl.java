package com.rapid.module.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.module.party.dao.PartyGroupDAO;
import com.rapid.module.party.model.Party;
import com.rapid.module.party.model.PartyGroup;
import com.rapid.module.party.service.PartyOperService;

@Service
public class PartyGroupServiceImpl implements PartyOperService {
	
	@Autowired
	private PartyGroupDAO partyGroupDAO;

	@Override
	public int createPartyChildren(Party party) {
		PartyGroup partyGroup = (PartyGroup) party;
		partyGroupDAO.insert(partyGroup);
		return 0;
	}


}
