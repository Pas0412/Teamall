package org.linlinjava.litemall.db.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class LitemallUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    public static final Boolean IS_DELETED = Deleted.IS_DELETED.value();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    public static final Boolean NOT_DELETED = Deleted.NOT_DELETED.value();

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.gender
     *
     * @mbg.generated
     */
    private Byte gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.birthday
     *
     * @mbg.generated
     */
    private LocalDate birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.last_login_time
     *
     * @mbg.generated
     */
    private LocalDateTime lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.last_login_ip
     *
     * @mbg.generated
     */
    private String lastLoginIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.user_level
     *
     * @mbg.generated
     */
    private Byte userLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.nickname
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.mobile
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.avatar
     *
     * @mbg.generated
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.weixin_openid
     *
     * @mbg.generated
     */
    private String weixinOpenid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.session_key
     *
     * @mbg.generated
     */
    private String sessionKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.status
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.deleted
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.balance
     *
     * @mbg.generated
     */
    private BigDecimal balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.first_vip_time
     *
     * @mbg.generated
     */
    private LocalDateTime firstVipTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.become_vip_time
     *
     * @mbg.generated
     */
    private LocalDateTime becomeVipTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.vip_expire_time
     *
     * @mbg.generated
     */
    private LocalDateTime vipExpireTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.agent_role_id
     *
     * @mbg.generated
     */
    private Integer agentRoleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_user.parent_inviter_id
     *
     * @mbg.generated
     */
    private Integer parentInviterId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.id
     *
     * @return the value of litemall_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.id
     *
     * @param id the value for litemall_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.username
     *
     * @return the value of litemall_user.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.username
     *
     * @param username the value for litemall_user.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.password
     *
     * @return the value of litemall_user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.password
     *
     * @param password the value for litemall_user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.gender
     *
     * @return the value of litemall_user.gender
     *
     * @mbg.generated
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.gender
     *
     * @param gender the value for litemall_user.gender
     *
     * @mbg.generated
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.birthday
     *
     * @return the value of litemall_user.birthday
     *
     * @mbg.generated
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.birthday
     *
     * @param birthday the value for litemall_user.birthday
     *
     * @mbg.generated
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.last_login_time
     *
     * @return the value of litemall_user.last_login_time
     *
     * @mbg.generated
     */
    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.last_login_time
     *
     * @param lastLoginTime the value for litemall_user.last_login_time
     *
     * @mbg.generated
     */
    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.last_login_ip
     *
     * @return the value of litemall_user.last_login_ip
     *
     * @mbg.generated
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.last_login_ip
     *
     * @param lastLoginIp the value for litemall_user.last_login_ip
     *
     * @mbg.generated
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.user_level
     *
     * @return the value of litemall_user.user_level
     *
     * @mbg.generated
     */
    public Byte getUserLevel() {
        return userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.user_level
     *
     * @param userLevel the value for litemall_user.user_level
     *
     * @mbg.generated
     */
    public void setUserLevel(Byte userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.nickname
     *
     * @return the value of litemall_user.nickname
     *
     * @mbg.generated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.nickname
     *
     * @param nickname the value for litemall_user.nickname
     *
     * @mbg.generated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.mobile
     *
     * @return the value of litemall_user.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.mobile
     *
     * @param mobile the value for litemall_user.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.avatar
     *
     * @return the value of litemall_user.avatar
     *
     * @mbg.generated
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.avatar
     *
     * @param avatar the value for litemall_user.avatar
     *
     * @mbg.generated
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.weixin_openid
     *
     * @return the value of litemall_user.weixin_openid
     *
     * @mbg.generated
     */
    public String getWeixinOpenid() {
        return weixinOpenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.weixin_openid
     *
     * @param weixinOpenid the value for litemall_user.weixin_openid
     *
     * @mbg.generated
     */
    public void setWeixinOpenid(String weixinOpenid) {
        this.weixinOpenid = weixinOpenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.session_key
     *
     * @return the value of litemall_user.session_key
     *
     * @mbg.generated
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.session_key
     *
     * @param sessionKey the value for litemall_user.session_key
     *
     * @mbg.generated
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.status
     *
     * @return the value of litemall_user.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.status
     *
     * @param status the value for litemall_user.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.add_time
     *
     * @return the value of litemall_user.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.add_time
     *
     * @param addTime the value for litemall_user.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.update_time
     *
     * @return the value of litemall_user.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.update_time
     *
     * @param updateTime the value for litemall_user.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? Deleted.IS_DELETED.value() : Deleted.NOT_DELETED.value());
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.deleted
     *
     * @return the value of litemall_user.deleted
     *
     * @mbg.generated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.deleted
     *
     * @param deleted the value for litemall_user.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.balance
     *
     * @return the value of litemall_user.balance
     *
     * @mbg.generated
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.balance
     *
     * @param balance the value for litemall_user.balance
     *
     * @mbg.generated
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.first_vip_time
     *
     * @return the value of litemall_user.first_vip_time
     *
     * @mbg.generated
     */
    public LocalDateTime getFirstVipTime() {
        return firstVipTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.first_vip_time
     *
     * @param firstVipTime the value for litemall_user.first_vip_time
     *
     * @mbg.generated
     */
    public void setFirstVipTime(LocalDateTime firstVipTime) {
        this.firstVipTime = firstVipTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.become_vip_time
     *
     * @return the value of litemall_user.become_vip_time
     *
     * @mbg.generated
     */
    public LocalDateTime getBecomeVipTime() {
        return becomeVipTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.become_vip_time
     *
     * @param becomeVipTime the value for litemall_user.become_vip_time
     *
     * @mbg.generated
     */
    public void setBecomeVipTime(LocalDateTime becomeVipTime) {
        this.becomeVipTime = becomeVipTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.vip_expire_time
     *
     * @return the value of litemall_user.vip_expire_time
     *
     * @mbg.generated
     */
    public LocalDateTime getVipExpireTime() {
        return vipExpireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.vip_expire_time
     *
     * @param vipExpireTime the value for litemall_user.vip_expire_time
     *
     * @mbg.generated
     */
    public void setVipExpireTime(LocalDateTime vipExpireTime) {
        this.vipExpireTime = vipExpireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.agent_role_id
     *
     * @return the value of litemall_user.agent_role_id
     *
     * @mbg.generated
     */
    public Integer getAgentRoleId() {
        return agentRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.agent_role_id
     *
     * @param agentRoleId the value for litemall_user.agent_role_id
     *
     * @mbg.generated
     */
    public void setAgentRoleId(Integer agentRoleId) {
        this.agentRoleId = agentRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_user.parent_inviter_id
     *
     * @return the value of litemall_user.parent_inviter_id
     *
     * @mbg.generated
     */
    public Integer getParentInviterId() {
        return parentInviterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_user.parent_inviter_id
     *
     * @param parentInviterId the value for litemall_user.parent_inviter_id
     *
     * @mbg.generated
     */
    public void setParentInviterId(Integer parentInviterId) {
        this.parentInviterId = parentInviterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", IS_DELETED=").append(IS_DELETED);
        sb.append(", NOT_DELETED=").append(NOT_DELETED);
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", userLevel=").append(userLevel);
        sb.append(", nickname=").append(nickname);
        sb.append(", mobile=").append(mobile);
        sb.append(", avatar=").append(avatar);
        sb.append(", weixinOpenid=").append(weixinOpenid);
        sb.append(", sessionKey=").append(sessionKey);
        sb.append(", status=").append(status);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", balance=").append(balance);
        sb.append(", firstVipTime=").append(firstVipTime);
        sb.append(", becomeVipTime=").append(becomeVipTime);
        sb.append(", vipExpireTime=").append(vipExpireTime);
        sb.append(", agentRoleId=").append(agentRoleId);
        sb.append(", parentInviterId=").append(parentInviterId);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LitemallUser other = (LitemallUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getLastLoginIp() == null ? other.getLastLoginIp() == null : this.getLastLoginIp().equals(other.getLastLoginIp()))
            && (this.getUserLevel() == null ? other.getUserLevel() == null : this.getUserLevel().equals(other.getUserLevel()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getWeixinOpenid() == null ? other.getWeixinOpenid() == null : this.getWeixinOpenid().equals(other.getWeixinOpenid()))
            && (this.getSessionKey() == null ? other.getSessionKey() == null : this.getSessionKey().equals(other.getSessionKey()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getFirstVipTime() == null ? other.getFirstVipTime() == null : this.getFirstVipTime().equals(other.getFirstVipTime()))
            && (this.getBecomeVipTime() == null ? other.getBecomeVipTime() == null : this.getBecomeVipTime().equals(other.getBecomeVipTime()))
            && (this.getVipExpireTime() == null ? other.getVipExpireTime() == null : this.getVipExpireTime().equals(other.getVipExpireTime()))
            && (this.getAgentRoleId() == null ? other.getAgentRoleId() == null : this.getAgentRoleId().equals(other.getAgentRoleId()))
            && (this.getParentInviterId() == null ? other.getParentInviterId() == null : this.getParentInviterId().equals(other.getParentInviterId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getLastLoginIp() == null) ? 0 : getLastLoginIp().hashCode());
        result = prime * result + ((getUserLevel() == null) ? 0 : getUserLevel().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getWeixinOpenid() == null) ? 0 : getWeixinOpenid().hashCode());
        result = prime * result + ((getSessionKey() == null) ? 0 : getSessionKey().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getFirstVipTime() == null) ? 0 : getFirstVipTime().hashCode());
        result = prime * result + ((getBecomeVipTime() == null) ? 0 : getBecomeVipTime().hashCode());
        result = prime * result + ((getVipExpireTime() == null) ? 0 : getVipExpireTime().hashCode());
        result = prime * result + ((getAgentRoleId() == null) ? 0 : getAgentRoleId().hashCode());
        result = prime * result + ((getParentInviterId() == null) ? 0 : getParentInviterId().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    public enum Deleted {
        NOT_DELETED(new Boolean("0"), "未删除"),
        IS_DELETED(new Boolean("1"), "已删除");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        private final Boolean value;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        private final String name;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        Deleted(Boolean value, String name) {
            this.value = value;
            this.name = name;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public Boolean getValue() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public Boolean value() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String getName() {
            return this.name;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        username("username", "username", "VARCHAR", false),
        password("password", "password", "VARCHAR", true),
        gender("gender", "gender", "TINYINT", false),
        birthday("birthday", "birthday", "DATE", false),
        lastLoginTime("last_login_time", "lastLoginTime", "TIMESTAMP", false),
        lastLoginIp("last_login_ip", "lastLoginIp", "VARCHAR", false),
        userLevel("user_level", "userLevel", "TINYINT", false),
        nickname("nickname", "nickname", "VARCHAR", false),
        mobile("mobile", "mobile", "VARCHAR", false),
        avatar("avatar", "avatar", "VARCHAR", false),
        weixinOpenid("weixin_openid", "weixinOpenid", "VARCHAR", false),
        sessionKey("session_key", "sessionKey", "VARCHAR", false),
        status("status", "status", "TINYINT", true),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false),
        balance("balance", "balance", "DECIMAL", false),
        firstVipTime("first_vip_time", "firstVipTime", "TIMESTAMP", false),
        becomeVipTime("become_vip_time", "becomeVipTime", "TIMESTAMP", false),
        vipExpireTime("vip_expire_time", "vipExpireTime", "TIMESTAMP", false),
        agentRoleId("agent_role_id", "agentRoleId", "INTEGER", false),
        parentInviterId("parent_inviter_id", "parentInviterId", "INTEGER", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_user
         *
         * @mbg.generated
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}