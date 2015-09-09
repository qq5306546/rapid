package com.rapid.module.party.model;


@SuppressWarnings("serial")
public class PartyGroup extends Party {

    // Fields

    private String groupName;		//组织名称
    private String groupNameLocal;		//组织英文名称
    private String officeSiteName;		//办公地点
    private String comments;		//备注
    
    

    
    public PartyGroup() {
    }

    

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupNameLocal(String groupNameLocal) {
        this.groupNameLocal = groupNameLocal;
    }

    public String getGroupNameLocal() {
        return this.groupNameLocal;
    }

    public void setOfficeSiteName(String officeSiteName) {
        this.officeSiteName = officeSiteName;
    }

    public String getOfficeSiteName() {
        return this.officeSiteName;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return this.comments;
    }

}