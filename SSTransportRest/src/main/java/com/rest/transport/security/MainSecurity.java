package com.rest.transport.security;


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

import com.rest.transport.security.jwt.JwtEntryPoint;
import com.rest.transport.security.jwt.JwtTokenFilter;
import com.rest.transport.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter{
	
	  @Autowired
	    UserDetailsServiceImpl userDetailsService;

	    @Autowired
	    JwtEntryPoint jwtEntryPoint;

	    @Bean
	    public JwtTokenFilter jwtTokenFilter(){
	        return new JwtTokenFilter();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }

	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected AuthenticationManager authenticationManager() throws Exception {
	        return super.authenticationManager();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.cors().and().csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/auth/**", "/email/**/deofuscar", "/email/**/deleteEmail","/pais/**" , "/provincia/**" , "/usuario/**/ActivarUsuario").permitAll()
	                .antMatchers().anonymous()
	                .anyRequest().authenticated()
	                .and()
	                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
	                .and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
	    /*
	     *     .authorizeRequests()
            .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**")
                .permitAll()
            .antMatchers("/secure/rest/**")
                .authenticated()
            .antMatchers("/register**")
                .anonymous()
            .antMatchers("/login**")
                .anonymous()
            .and();
	     * */

}
