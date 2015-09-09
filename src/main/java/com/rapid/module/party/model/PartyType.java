package com.rapid.module.party.model;

import com.rapid.core.base.mybatis.model.BaseModel;

/**
 * 当事人类型
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class PartyType extends BaseModel {

    // Fields

    private String partyTypeId;		//当事人类型标识
    private String parentTypeId;		//上级类型标识
    private String hasTable;		//有库表
    private String enable;			//启用 Y-是，N-否
    private String description;		//描述
    

    
    public PartyType() {
    }

    

    public void setPartyTypeId(String partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    public String getPartyTypeId() {
        return this.partyTypeId;
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

    public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}