package com.rapid.module.party.model;

import com.rapid.core.base.mybatis.model.BaseModel;

/**
 * 当事人关系类型
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class PartyRelationshipType extends BaseModel {

    // Fields

    private String partyRelationshipTypeId;		//当事人类型标识
    private String parentTypeId;		
    private String hasTable;		//有库表
    private String partyRelationshipName;		//描述
    private String description;		//当事人关系名称
    
    

    
    public PartyRelationshipType() {
    }

    

    public void setPartyRelationshipTypeId(String partyRelationshipTypeId) {
        this.partyRelationshipTypeId = partyRelationshipTypeId;
    }

    public String getPartyRelationshipTypeId() {
        return this.partyRelationshipTypeId;
    }

    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    public String getParentTypeId() {
        return this.parentTypeId;
    }

    public void setHasTable(String hasTable) {
        this.hasTable = hasTable;
    }

    public String getHasTable() {
        return this.hasTable;
    }

    public void setPartyRelationshipName(String partyRelationshipName) {
        this.partyRelationshipName = partyRelationshipName;
    }

    public String getPartyRelationshipName() {
        return this.partyRelationshipName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}