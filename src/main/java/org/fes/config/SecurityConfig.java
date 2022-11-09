package org.fes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//TODO we should avoid WebSecurityConfigurerAdapter
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * We allow anyone to access our API (normally it would be secured)
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
    }

}
