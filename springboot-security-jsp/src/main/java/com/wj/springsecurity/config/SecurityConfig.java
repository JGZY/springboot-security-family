package com.wj.springsecurity.config;

import com.wj.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)//开启@Secured注解
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login.jsp","/failer.jsp","/css/**","/img/**","/plugins/**","/favicon.ico").permitAll()
                .antMatchers("/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login.jsp").loginProcessingUrl("/login")
                .successForwardUrl("/index.jsp").failureForwardUrl("/failer.jsp")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login.jsp")
                .invalidateHttpSession(true)//是否清空session
                .permitAll()
                .and()
                .csrf().disable();
    }

    /**
     * 认证的来源（内存还是数据库）
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
