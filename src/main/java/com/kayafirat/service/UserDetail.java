package com.kayafirat.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.kayafirat.model.User;

public class UserDetail extends User implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public UserDetail(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

}
