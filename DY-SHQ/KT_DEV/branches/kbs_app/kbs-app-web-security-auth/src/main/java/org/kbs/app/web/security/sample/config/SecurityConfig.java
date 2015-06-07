package org.kbs.app.web.security.sample.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//注入org.exam.service.impl.UserDetailsServiceImpl
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public PasswordEncoder passwordEncoder(){
		//这里的strength为4-31位,设置成16都觉得编码有点慢了
		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(4);
		return passwordEncoder;
	}
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		//本地化(不完全)
		ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:org/springframework/security/messages");
		return messageSource;
	}
	//暴露AuthenticationManager注册成Bean供@EnableGlobalMethodSecurity使用
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Bean
	public SessionRegistry sessionRegistry(){
		SessionRegistry sessionRegistry=new SessionRegistryImpl();
		return sessionRegistry;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**","/exception/**");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
				.and().formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter("username").passwordParameter("password").permitAll()
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll()
				.and().rememberMe().key("9D119EE5A2B7DAF6B4DC1EF871D0AC3C")
				.and().exceptionHandling().accessDeniedPage("/exception/403")
				.and().sessionManagement().maximumSessions(1).expiredUrl("/login?expired").sessionRegistry(sessionRegistry());
	}
}
