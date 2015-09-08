package com.rapid.module.party.service.impl;

import org.springframework.stereotype.Service;

import com.rapid.core.base.service.BaseServiceImpl;
import com.rapid.module.party.model.PartyType;
import com.rapid.module.party.service.PartyTypeService;

@Service
public class PartyTypeServiceImpl extends BaseServiceImpl<PartyType, String> implements PartyTypeService {

	@Override
	public String selectParentId(String partyTypeId) {
		PartyType partyType = selectById(partyTypeId);
		
		return null;
	}

}
