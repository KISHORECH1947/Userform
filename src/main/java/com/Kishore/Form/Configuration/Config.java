package com.Kishore.Form.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


    @Configuration
    @EnableWebSecurity
    public class Config {
        @Bean
        public UserDetailsService userDetailsService(PasswordEncoder encoder){
            UserDetails admin= org.springframework.security.core.userdetails.User.withUsername("admin").password(encoder.encode("admin")).roles("ADMIN").build();
            UserDetails user= org.springframework.security.core.userdetails.User.withUsername("user").password(passwordEncoder().encode("user")).roles("User").build();
            return new InMemoryUserDetailsManager(user,admin);
        }
        @Bean
        public PasswordEncoder passwordEncoder(){
            return  new BCryptPasswordEncoder();
        }
    }


