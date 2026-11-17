package com.example.gateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {
 @Bean
 SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
  return http.csrf(csrf -> csrf.disable())
    .authorizeExchange(exchanges -> exchanges
      .pathMatchers("/admin/**").hasRole("ADMIN")
      .pathMatchers("/user/**").hasAnyRole("USER", "ADMIN")
      .anyExchange().authenticated())
    .httpBasic(Customizer.withDefaults())
    .build();
 }
 @Bean
 PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
 @Bean
 MapReactiveUserDetailsService userDetailsService(PasswordEncoder encoder) {
  UserDetails admin = User.withUsername("admin").password(encoder.encode("admin123")).roles("ADMIN").build();
  UserDetails user = User.withUsername("user").password(encoder.encode("user123")).roles("USER").build();
  return new MapReactiveUserDetailsService(admin, user);
 }
}
