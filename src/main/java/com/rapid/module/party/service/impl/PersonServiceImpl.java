package com.rapid.module.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.core.exception.BaseException;
import com.rapid.module.party.dao.PersonDAO;
import com.rapid.module.party.model.Party;
import com.rapid.module.party.model.Person;
import com.rapid.module.party.service.PartyOperService;
import com.validmodel.Validator;
import com.validmodel.exception.ValidateException;

@Service
public class PersonServiceImpl implements PartyOperService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	public int createPartyChildren(Party party) {
		try {
			Person person = (Person) party;
			Validator.vaildate(person);
			return personDAO.insert(person);
		} catch (ValidateException e) {
			throw new BaseException(e);
		}
	}


}
