package es.agenda.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("agenda")
				.password("agenda").roles("USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/listado").hasAnyRole("USER", "ADMIN")
			.antMatchers("/nuevo").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/login.jsp")
			.failureUrl("/login.jsp?error=1")
		    .loginProcessingUrl("/login")
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/listado.html");
	}
	
}