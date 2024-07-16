
package com.smartnet.projet.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.smartnet.projet.Model.User;
import com.smartnet.projet.Repository.UserRepository;


@Service 
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired 
	private UserRepository userRepository;

	@Override

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional <User> user = userRepository.findByUsername(username); user.orElseThrow(() -> new
			UsernameNotFoundException("User Not Found with username: " + username));

	return user.map(UserDetailsImpl::new).get(); }


}
