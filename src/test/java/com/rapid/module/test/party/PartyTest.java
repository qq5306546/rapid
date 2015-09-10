package com.rapid.module.test.party;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rapid.module.party.model.PartyGroup;
import com.rapid.module.party.service.PartyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"})
public class PartyTest {
	
	@Autowired
	private PartyService partyService;

	@Test
	public void createParty() {
		PartyGroup pg = new PartyGroup();
		pg.setPartyId("3333");
		pg.setGroupName("测试");
		pg.setPartyTypeId("1");
		partyService.createParty(pg);
	}
}
