package com.rapid.module.party.model;

import java.util.Date;

import com.rapid.common.base.mybatis.model.BaseModel;

@SuppressWarnings("serial")
public class Person extends BaseModel {

    // Fields

    private String partyId;		//当事人唯一标识
    private String realname;		//真实姓名
    private String nickname;		//昵称
    private String gender;		//性别
    private Date birthDate;		//出生日期
    private String comments;		//备注
    
    

    
    public Person() {
    }

    

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return this.comments;
    }

}