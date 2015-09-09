package com.rapid.module.party.model;

import java.util.Date;

import com.rapid.core.base.mybatis.model.BaseModel;

/**
 * 当事人
 * @author wubei
 *
 */
@SuppressWarnings("serial")
public class Party extends BaseModel {

    // Fields

    private String partyId;		//当事人标识
    private String partyTypeId;		//当事人类型
    private Date createStamp;		//创建时间
    private String createByUserLogin; //创建当事人登录账号
    
    

    
    public Party() {
    }

    

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public void setPartyTypeId(String partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    public String getPartyTypeId() {
        return this.partyTypeId;
    }

    public void setCreateStamp(Date createStamp) {
        this.createStamp = createStamp;
    }

    public Date getCreateStamp() {
        return this.createStamp;
    }

	public String getCreateByUserLogin() {
		return createByUserLogin;
	}

	public void setCreateByUserLogin(String createByUserLogin) {
		this.createByUserLogin = createByUserLogin;
	}

}