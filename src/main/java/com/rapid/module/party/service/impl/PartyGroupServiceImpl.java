package com.rapid.module.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.core.exception.BaseException;
import com.rapid.module.party.dao.PartyGroupDAO;
import com.rapid.module.party.model.Party;
import com.rapid.module.party.model.PartyGroup;
import com.rapid.module.party.service.PartyOperService;
import com.validmodel.Validator;
import com.validmodel.exception.ValidateException;

@Service
public class PartyGroupServiceImpl implements PartyOperService {
	
	@Autowired
	private PartyGroupDAO partyGroupDAO;

	@Override
	public int createPartyChildren(Party party) {
		try {
			PartyGroup partyGroup = (PartyGroup) party;
			Validator.vaildate(partyGroup);
			return partyGroupDAO.insert(partyGroup);
		} catch (ValidateException e) {
			throw new BaseException(e);
		}
		
	}


}
