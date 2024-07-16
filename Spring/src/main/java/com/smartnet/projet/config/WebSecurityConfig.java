
  package com.smartnet.projet.config;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
  import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
  import org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
  import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
  import org.springframework.security.config.http.SessionCreationPolicy;
  import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
  import org.springframework.security.crypto.password.PasswordEncoder;
  import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

  import com.smartnet.projet.Service.UserDetailsServiceImpl;
  import com.smartnet.projet.security.JwtAuthEntryPointJwt;
  import com.smartnet.projet.security.JwtRequestFilter;
  
  
  @Configuration
  
  @EnableWebSecurity
  
  @EnableGlobalMethodSecurity(prePostEnabled = true) 
  public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
      @Autowired 
      
      UserDetailsServiceImpl userDetailsService;
  	@Autowired
  	private JwtAuthEntryPointJwt unauthorizedHandler;

  	@Bean
  	public JwtRequestFilter authenticationJwtTokenFilter() {
  		return new JwtRequestFilter();
  	}
  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("ssssss");
		http.cors().and().csrf().disable()
		.authorizeRequests().antMatchers("/api/users/login","/api/articles/all","/api/annonces/all","/api/clients/register","/api/Imgarticles/**","/api/Imgclientss/**","/api/Imgarticlesd/**","/api/Imgclients/**","/api/Imgannonces/**").permitAll()
		.anyRequest().authenticated().and()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
  
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
  
  }
  

  
  
  
 