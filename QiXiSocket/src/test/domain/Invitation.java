package test.domain;

import java.util.Date;

public class Invitation {
    private Integer id;

    private Integer inviterUserId;

    private Integer inviteeUserId;

    private Date inviteTime;

    private String isAccepted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public Integer getInviterUsers() {
		return inviterUserId;
	}

	public void setInviterUsers(Integer inviterUsers) {
		this.inviterUserId = inviterUsers;
	}

	public Integer getInviteeUsers() {
		return inviteeUserId;
	}

	public void setInviteeUsers(Integer inviteeUsers) {
		this.inviteeUserId = inviteeUsers;
	}

	public Date getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Date inviteTime) {
        this.inviteTime = inviteTime;
    }

    public String getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        this.isAccepted = isAccepted == null ? null : isAccepted.trim();
    }

	@Override
	public String toString() {
		return "Invitation [id=" + id + ", inviteTime=" + inviteTime + ", isAccepted=" + isAccepted + "]";
	}
}