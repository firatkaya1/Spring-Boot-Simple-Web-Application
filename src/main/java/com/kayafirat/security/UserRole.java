package com.kayafirat.security;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.google.common.collect.Sets;

public enum UserRole {
	USER(Sets.newHashSet(UserPermissions.BOOK_READ)),
	ADMIN(Sets.newHashSet(UserPermissions.BOOK_CREATE,
						  UserPermissions.BOOK_READ,
						  UserPermissions.BOOK_UPDATE,
						  UserPermissions.BOOK_DELETE));	
	
	private final Set<UserPermissions> permissions;

	UserRole(Set<UserPermissions> permissions) {
		this.permissions = permissions;
	}
	
	public Set<UserPermissions> getPermissions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getSimpleGrantedAuthority() {
		 Set<SimpleGrantedAuthority> permissions=getPermissions().stream()
						.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
						.collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
		return permissions;
		 
	}
	
	
	
}
