package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

   
   public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // @Bean
    // UserDetailsService userDetailsService(PasswordEncoder encoder) {

    //     UserDetails admin = User.withUsername("shyam")
    //             .password(encoder.encode("Pwd1"))
    //             .roles("ADMIN")
    //             .build();

    //     UserDetails user = User.withUsername("jhon")
    //             .password(encoder.encode("Pwd2"))
    //             .roles("USER")
    //             .build();

    //     return new InMemoryUserDetailsManager(admin, user);

    // }

    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

         return http.csrf((csrf)->csrf.disable())
                    .authorizeHttpRequests((authorizehttprequest)->
                     authorizehttprequest
                     .requestMatchers("/todo/userRegister","/todo/login").permitAll()
                     .anyRequest().authenticated()
                                
                    )
                    
    .httpBasic(Customizer.withDefaults())
                
         .build();

    }

    @Bean
     PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=
        new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

}
