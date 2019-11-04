package cn.ibm.com.core.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cn.ibm.com.core.filter.JwtTokenAuthenticationFilter;


@EnableWebSecurity 	
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	public void configure(WebSecurity web) {
		final String[] SWAGGER_UI = { "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**",
				"/actuator/**", "/account/v2/api-docs" };

		web.ignoring().antMatchers(SWAGGER_UI);
	}
 
	@Override
  	protected void configure(HttpSecurity http) throws Exception {
    	   http
    	   .cors().and()
		.csrf().disable()
	 	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 	
		.and()
		    .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)) 	
		.and()
		   .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		   .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
		   .antMatchers(HttpMethod.POST, "/admin/user/add").permitAll() 
		   .antMatchers(HttpMethod.GET, "/training/mentor/list").permitAll()
		   .antMatchers(HttpMethod.GET, "/training/mentor/book").hasRole("user")
		   .antMatchers(HttpMethod.GET, "/admin/user/list").hasRole("user")
		   .antMatchers(HttpMethod.GET, "/training/mentor/searchcourse").hasRole("user")
		   .antMatchers("/account/**", "/course/**", "/mentor/**").hasAnyRole("admin","mentor")
		   .anyRequest().authenticated(); 
	}
	
	@Bean
  	public JwtConfig jwtConfig() {
    	   return new JwtConfig();
  	}
}
