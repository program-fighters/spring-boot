package com.java.practice.configure;

import com.java.practice.utils.UrlPaths;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConstatnt extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(UrlPaths.TIME)
                .antMatchers(UrlPaths.INDEX)
                .antMatchers(UrlPaths.API_VERSION);
    }
}
