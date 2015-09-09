package com.rapid.module.party.model;

import com.rapid.core.base.mybatis.model.BaseModel;

/**
 * 当事人角色
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class PartyRole extends BaseModel {

    // Fields

    private String partyId;		//当事人唯一标识
    private String roleTypeId;		//角色类型唯一标识
    

    
    public PartyRole() {
    }

    

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public void setRoleTypeId(String roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    public String getRoleTypeId() {
        return this.roleTypeId;
    }

}