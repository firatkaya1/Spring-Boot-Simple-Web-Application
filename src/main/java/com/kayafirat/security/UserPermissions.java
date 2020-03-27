package com.kayafirat.security;

public enum UserPermissions {

	BOOK_CREATE("book:create"),
	BOOK_READ("book:read"),
	BOOK_DELETE("book:delete"),
	BOOK_UPDATE("book:update");
	
	private final String permission;
	
	UserPermissions(String permission){
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}
	
}
