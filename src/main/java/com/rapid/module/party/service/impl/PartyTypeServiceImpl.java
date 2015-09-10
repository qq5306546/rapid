package com.rapid.module.party.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.core.exception.BaseException;
import com.rapid.module.party.dao.PartyTypeDAO;
import com.rapid.module.party.model.PartyType;
import com.rapid.module.party.service.PartyTypeService;

@Service
public class PartyTypeServiceImpl implements PartyTypeService {
	
	@Autowired
	private PartyTypeDAO partyTypeDAO;

	@Override
	public String selectParentId(String partyTypeId) {
		PartyType partyType = partyTypeDAO.selectById(partyTypeId);
		if (partyType == null) {
			throw new BaseException(String.format("请检查party_type表中唯一标识为[%s]的种子数据是否存在", partyTypeId));
		} else {
			if (partyType.getHasTable().equals("N") && StringUtils.isNotBlank(partyType.getParentTypeId())) {
				return this.selectParentId(partyType.getParentTypeId());
			} 
		}
		return partyType.getPartyTypeId();
	}

}
