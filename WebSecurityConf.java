package pl.keep.javac.oauthtest;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class WebSecurityConf extends WebSecurityConfigurerAdapter{


        @Bean
        public PasswordEncoder passwordEncoder () {
            return new BCryptPasswordEncoder();
        }
        @Override
        protected void configure (AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("admin")
                    .password(passwordEncoder().encode("admin123"))
                    .roles("admin");
        }
        @Override
        protected void configure (HttpSecurity http)throws Exception {
            http.authorizeRequests().antMatchers("/login").authenticated()
                    .and()
                    .formLogin();
        }
    }
