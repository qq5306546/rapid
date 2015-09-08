package com.rapid.module.party.dao;

import com.rapid.core.base.mybatis.annotation.MyBatisDAO;
import com.rapid.core.base.mybatis.dao.BaseDAO;
import com.rapid.module.party.model.Person;

@MyBatisDAO
public interface PersonDAO extends BaseDAO<Person, String>  {


}