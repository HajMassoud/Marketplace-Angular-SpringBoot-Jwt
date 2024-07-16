
package com.smartnet.projet.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.smartnet.projet.Model.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String email;
	private boolean isActive;
	private String password;
	private String role;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.isActive = user.isActive();
		this.role=user.getRole();
		this.authorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

	}

	public UserDetailsImpl() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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
		return isActive;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
