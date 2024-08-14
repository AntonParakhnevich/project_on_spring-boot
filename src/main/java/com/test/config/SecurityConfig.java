package com.test.config;

import com.test.handler.CustomAuthenticationSuccessHandler;
import com.test.model.RoleName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

  public SecurityConfig(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
    this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(CsrfConfigurer::disable)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                new AntPathRequestMatcher("/login/"),
                new AntPathRequestMatcher("/registration/**"),
                new AntPathRequestMatcher("/logout/")
            ).permitAll()
            .requestMatchers(
                new AntPathRequestMatcher("/admin/**")
            ).hasAnyAuthority(RoleName.ADMIN.getAuthority(), RoleName.SUPER_ADMIN.getAuthority())
            .requestMatchers(
                new AntPathRequestMatcher("/private-area/**")
            ).hasAuthority(RoleName.USER.getAuthority())
            .anyRequest().authenticated())
        .formLogin(login -> login.loginPage("/login")
            .successHandler(customAuthenticationSuccessHandler)
            .permitAll())
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .deleteCookies("JSESSIONID"));
    return http.build();
  }
}
