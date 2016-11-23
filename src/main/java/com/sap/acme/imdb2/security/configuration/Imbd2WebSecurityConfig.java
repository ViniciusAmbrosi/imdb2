package com.sap.acme.imdb2.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.sap.acme.imdb2.security.service.Imdb2UserDetailsService;

@Configuration
@EnableWebSecurity
public class Imbd2WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Imdb2UserDetailsService imdb2UserDetailsService;
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
        		.antMatchers("/home", "/movie/details/**").permitAll()
        		.antMatchers("/movie/edit/**").access("hasRole('ROLE_MOD')")
        		.antMatchers(HttpMethod.POST, "/movie/register").access("hasRole('ROLE_MOD')")
        		.antMatchers("/wishlist/**").access("hasRole('ROLE_USER')")
                .antMatchers("/movie/save", "/rest/users", "/rest/user/**", "/movie/delete").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.GET, "/movie/register").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()
                .antMatchers("/css/**", "/js/**", "/Images/**").permitAll().anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/Access_Denied")
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .permitAll().and().csrf().disable();
    }
	 
    @Autowired
    public void setDetailsService(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
	        .userDetailsService(imdb2UserDetailsService)
	        .passwordEncoder(new BCryptPasswordEncoder());
    }
}
