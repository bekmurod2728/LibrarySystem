package com.librarysystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.librarysystem.service.UserService;

import static com.librarysystem.entity.ApplicationUserPermission.*;

@EnableWebSecurity
public class SecurityApp {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;
    private final JwtRequestFilter jwtRequestFilter;
    @Autowired
    public SecurityApp(BCryptPasswordEncoder bCryptPasswordEncoder,
                       UserService userService, JwtRequestFilter jwtRequestFilter) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;

        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception {
        httpsecurity
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/user/bron").hasAuthority(BRON_BOOK.getPermission())
                .antMatchers(HttpMethod.GET,"/book/show").hasAuthority(MANITORING_BOOK_MANAGMENT.getPermission())
                .antMatchers(HttpMethod.GET,"/bron_book_show").hasAuthority(MANITORING_BOOK_MANAGMENT.getPermission())
                .antMatchers(HttpMethod.GET,"/borrow-book_show").hasAuthority(MANITORING_BOOK_MANAGMENT.getPermission())
                .antMatchers(HttpMethod.POST,"/book/add").hasAuthority(BOOK_ADD.getPermission())
                .antMatchers("/**").hasAuthority(CONTROL.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return httpsecurity.build();

    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
