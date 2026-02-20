package com.first.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Autowired
	    private JwtFilter jwtFilter;

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    	
	    	http.csrf().disable()
	    	//http.csrf(csrf -> csrf.disable())
	        //http.csrf(null).disable()
	            .authorizeHttpRequests()
	            .requestMatchers("/consumer/register", "/consumer/login").permitAll()
	            .requestMatchers("/add", "/update", "/delete/**").hasAuthority("ADMIN")
	            .requestMatchers("/buy/**").hasAuthority("CONSUMER")
	            .anyRequest().authenticated()
	            .and()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	    	return NoOpPasswordEncoder.getInstance();
	    }
}

