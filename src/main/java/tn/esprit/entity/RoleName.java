package tn.esprit.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements
GrantedAuthority{
	ADMIN,
	CLIENT
	;

	@Override
	public String getAuthority() {
		return "ROLE_" +name();
	}

}
