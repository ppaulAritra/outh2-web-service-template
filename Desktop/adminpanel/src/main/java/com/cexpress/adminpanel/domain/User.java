package com.cexpress.adminpanel.domain;

import java.util.List;

public class User {
	private String access_token;
	private String token_type;
	private String refresh_token;
	//private String expires_in;
	private long expires_in;
	private Long userId;
	private String scope;
	private String department;
	private List<Authority> authorities;
	private String isDeleted;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "User [access_token=" + access_token + ", token_type=" + token_type + ", refresh_token=" + refresh_token
				+ ", expires_in=" + expires_in + ", userId=" + userId + ", scope=" + scope + ", authorities="
				+ authorities + ", isDeleted=" + isDeleted + "]";
	}
	
	
	
	
	
	

	
}