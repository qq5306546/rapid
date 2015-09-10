package com.rapid.module.test.party;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rapid.module.party.model.RoleType;
import com.rapid.module.party.service.RoleTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"})
public class RoleTypeTest {
	
	@Autowired
	private RoleTypeService roleTypeService;

	@Test
	public void createRoleType() {
		RoleType roleType = new RoleType();
		roleType.setRoleTypeId("2222");
		roleType.setParentTypeId("1111");
		roleType.setNowTime();
	}
}
