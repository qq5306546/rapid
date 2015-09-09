package com.rapid.module.party.dao;

import com.rapid.core.base.mybatis.annotation.MyBatisDAO;
import com.rapid.core.base.mybatis.dao.BaseDAO;
import com.rapid.module.party.model.Party;

/**
 * 当事人DAO
 * @author wubei
 *
 */
@MyBatisDAO
public interface PartyDAO extends BaseDAO<Party, String> {


}