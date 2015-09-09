package com.rapid.module.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.module.party.dao.PersonDAO;
import com.rapid.module.party.model.Party;
import com.rapid.module.party.model.Person;
import com.rapid.module.party.service.PartyOperService;

@Service
public class PersonServiceImpl implements PartyOperService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	public int createPartyChildren(Party party) {
		Person person = (Person) party;
		personDAO.insert(person);
		return 0;
	}


}
