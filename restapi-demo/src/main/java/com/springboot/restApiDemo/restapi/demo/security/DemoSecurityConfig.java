package com.springboot.restApiDemo.restapi.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        /**
         *
         * ONLY IF TABLES ARE NOT USERS/AUTHORITIES
         */
        //this line is for the case we are not using default tables
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //get user in realtime
        //user_id, pw and active are columns from our custom table members
        //the ? mean that it will be resolved in runtime
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );
        //define query to retrieve authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );

        /**
         * IF TABLES ARE DEFAULT JSU NEXT LINE IS NEEDED
         */
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "employees").hasRole("ADMIN")
                );

        //use HTTP Basic authentication
        http.httpBasic();

        //disable Cross Site Forgery (CSRF) on REST Apis its normal to disable this
        http.csrf().disable();

        return http.build();
    }

}
