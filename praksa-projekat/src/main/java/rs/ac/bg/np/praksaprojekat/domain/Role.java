package rs.ac.bg.np.praksaprojekat.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    USER,
    ADMIN;

	@Override
	public String getAuthority() {
		return name();
	}
}
