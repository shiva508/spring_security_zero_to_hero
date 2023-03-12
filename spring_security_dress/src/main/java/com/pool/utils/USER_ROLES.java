package com.pool.utils;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.google.common.collect.Sets;
import static com.security.utils.USER_PERMISIONS.*;

public enum USER_ROLES {

	USER(Sets.newHashSet()), 
	ADMIN(Sets.newHashSet(ADMIN_WRITE,ADMIN_READ)),
	MANAGER(Sets.newHashSet(ADMIN_READ));

	private final Set<USER_PERMISIONS> permission;

	private USER_ROLES(Set<USER_PERMISIONS> permission) {
		this.permission = permission;
	}

	public Set<USER_PERMISIONS> getPermission() {
		return permission;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> permissions=getPermission()
						.stream()
						.map(permission->new SimpleGrantedAuthority(permission.name()))
						.collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return permissions;
	}
}
