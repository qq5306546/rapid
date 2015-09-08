package com.rapid.module.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.common.base.service.BaseServiceImpl;
import com.rapid.common.plugin.config.SystemGlobal;
import com.rapid.module.party.dao.PersonDAO;
import com.rapid.module.party.model.Party;
import com.rapid.module.party.service.PartyService;

@Service
public class PartyServiceImpl extends BaseServiceImpl<Party, String> implements PartyService {
	
	@Autowired
	private SystemGlobal systemGlobal;
	@Autowired
	private PersonDAO personDAO;

	public int createParty(Party party) {
		personDAO.select();
		return 0;
	}
}
