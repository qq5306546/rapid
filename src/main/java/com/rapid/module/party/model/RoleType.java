package com.rapid.module.party.model;

import com.rapid.core.base.mybatis.model.BaseModel;

/**
 * 角色类型
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class RoleType extends BaseModel {

    // Fields

    private String roleTypeId;		//角色类型唯一标识
    private String parentTypeId;		
    private String hasTable;		//有库表
    private String description;		//描述
    

    
    public RoleType() {
    }

    

    public void setRoleTypeId(String roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    public String getRoleTypeId() {
        return this.roleTypeId;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}