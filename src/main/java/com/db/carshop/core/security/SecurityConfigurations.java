package com.db.carshop.core.security;


import com.db.carshop.authentication.AuthenticationService;
import com.db.carshop.authentication.LoggedUser;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
    private AuthenticationService authenticationService;

    private TokenService tokenService;
    private LoggedUser loggedUser;
    private UserDetailsService userDetailsService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
            .userDetailsService(authenticationService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/employee").permitAll()
                .antMatchers(HttpMethod.GET, "/health-check").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(tokenFilter(), UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().sameOrigin();
        http.cors().and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**", "/health/**", "/h2-console/**");
    }

    /*@Bean
    public WebMvcConfigurer configureCors() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedHeaders("*");
            }
        };
    }*/

    private AuthenticationTokenFilter tokenFilter() {
        return new AuthenticationTokenFilter(tokenService, userDetailsService, loggedUser);
    }
}
