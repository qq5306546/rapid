package com.rapid.module.party.dao;

import com.rapid.common.base.mybatis.annotation.MyBatisDAO;
import com.rapid.common.base.mybatis.dao.BaseDAO;
import com.rapid.module.party.model.Party;

@MyBatisDAO
public interface PartyDAO extends BaseDAO<Party, String> {


}