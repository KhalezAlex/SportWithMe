package com.swm.sportwithme.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //    private static final String[] adminEndpoints = {};
    private static final String[] requestEndpoints = {"/", "/register", "/checkLoginForRegistration",
            "/checkPhoneForRegistration"};
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/scripts/**", "/styles/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(requestEndpoints).permitAll()
//                .antMatchers(adminEndpoints).hasRole("ADMIN")
                .anyRequest().authenticated();

//        http
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeHttpRequests((requests) -> requests
//                        .antMatchers("/", "/register", "/checkLoginForRegistration",
//                                "/checkPhoneForRegistration").permitAll()
//                        .anyRequest().permitAll()
//                )
//                .formLogin((form) -> form.loginPage("/login").permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
        detailsManager.createUser(getUser("user", "user", "USER"));
        detailsManager.createUser(getUser("admin", "admin", "ADMIN"));
        return detailsManager;
    }

    private UserDetails getUser(String username, String password, String roles) {
        return User.withDefaultPasswordEncoder()
                .username(username).password(password).roles(roles).build();
    }
}


//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .antMatchers("/", "/home").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form.loginPage("/login").permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }