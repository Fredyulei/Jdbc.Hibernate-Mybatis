package com.qingke.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invitation")
public class Invitation {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "invite_time")
	private String invite_time;
	@Column(name = "is_accepted")
	private String is_accepted;
	@ManyToOne
	@JoinColumn(name = "inviter_user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "invitee_user_id")
	private User users;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getInviter_user_id() {
//		return inviter_user_id;
//	}
//	public void setInviter_user_id(int inviter_user_id) {
//		this.inviter_user_id = inviter_user_id;
//	}
//	public int getInvitee_user_id() {
//		return invitee_user_id;
//	}
//	public void setInvitee_user_id(int invitee_user_id) {
//		this.invitee_user_id = invitee_user_id;
//	}
	public String getInvite_time() {
		return invite_time;
	}
	public void setInvite_time(String invite_time) {
		this.invite_time = invite_time;
	}
	public String getIs_accepted() {
		return is_accepted;
	}
	public void setIs_accepted(String is_accepted) {
		this.is_accepted = is_accepted;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", inviter_user_id=" + 
				", invite_time=" + invite_time + ", is_accepted=" + is_accepted + "]";
	}
	
}
