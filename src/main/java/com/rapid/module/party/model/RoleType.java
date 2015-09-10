package com.rapid.module.party.model;

import org.apache.commons.lang.StringUtils;

import com.rapid.core.base.mybatis.model.BaseModel;
import com.rapid.module.common.Status;

/**
 * 角色类型
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class RoleType extends BaseModel {

    // Fields

    private String roleTypeId;		//角色类型唯一标识
    private String parentTypeId;	//上级角色标识
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
    	if (StringUtils.isBlank(this.hasTable)) {
    		return Status.STATUS_N;
    	}
        return this.hasTable;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}