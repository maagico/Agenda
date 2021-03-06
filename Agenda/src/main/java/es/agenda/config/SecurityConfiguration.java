package es.agenda.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private DataSource dataSource;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        
		String usersByUsernameQuery = "select usuario, password, 'true' from usuarios where usuario = ?";
		String authoritiesByUsernameQuery = "select usuario, rol from usuarios usu inner join roles rol on(usu.role_id = rol.id) where usu.usuario = ?";
		
		auth.jdbcAuthentication()
        	.dataSource(dataSource)
        	.usersByUsernameQuery(usersByUsernameQuery)
    		.authoritiesByUsernameQuery(authoritiesByUsernameQuery);
    }
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/web/**").hasRole("USUARIO")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/login", "/css/**")
            .permitAll()
        .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/redirigir")
            .failureUrl("/login?error=true")
            .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/login?logout=true")
            .invalidateHttpSession(true)
            .permitAll()
		.and()
			.headers()
			.frameOptions()
			.disable();
	}
}