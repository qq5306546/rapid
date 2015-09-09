package com.rapid.module.party.dao;

import com.rapid.core.base.mybatis.annotation.MyBatisDAO;
import com.rapid.core.base.mybatis.dao.BaseDAO;
import com.rapid.module.party.model.Person;

/**
 * 当事人-人员DAO
 * @author wubei
 *
 */
@MyBatisDAO
public interface PersonDAO extends BaseDAO<Person, String>  {


}