package com.rapid.module.party.model;

import java.util.Date;

import com.rapid.core.base.mybatis.model.BaseModel;

/**
 * 当事人关系
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class PartyRelationship extends BaseModel {

    // Fields

    private String partyIdFrom;		//源当事人标识
    private String partyIdTo;		//目标当事人标识
    private String partyRelationshipTypeId;		//当事人类型
    private String roleTypeIdFrom;		//源当事人角色类型
    private String roleTypeIdTo;		//目标当事人角色类型
    private Date fromDate;		//开始日期
    private Date thruDate;		//结束日期
    
    

    
    public PartyRelationship() {
    }

    

    public void setPartyIdFrom(String partyIdFrom) {
        this.partyIdFrom = partyIdFrom;
    }

    public String getPartyIdFrom() {
        return this.partyIdFrom;
    }

    public void setPartyIdTo(String partyIdTo) {
        this.partyIdTo = partyIdTo;
    }

    public String getPartyIdTo() {
        return this.partyIdTo;
    }

    public void setPartyRelationshipTypeId(String partyRelationshipTypeId) {
        this.partyRelationshipTypeId = partyRelationshipTypeId;
    }

    public String getPartyRelationshipTypeId() {
        return this.partyRelationshipTypeId;
    }

    public void setRoleTypeIdFrom(String roleTypeIdFrom) {
        this.roleTypeIdFrom = roleTypeIdFrom;
    }

    public String getRoleTypeIdFrom() {
        return this.roleTypeIdFrom;
    }

    public void setRoleTypeIdTo(String roleTypeIdTo) {
        this.roleTypeIdTo = roleTypeIdTo;
    }

    public String getRoleTypeIdTo() {
        return this.roleTypeIdTo;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }

    public Date getThruDate() {
        return this.thruDate;
    }

}