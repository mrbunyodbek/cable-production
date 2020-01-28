package uz.cp.cableproduction.configs;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jasur")
                .password("{noop}qwerty")
                .roles("USER")
                .and()
                .withUser("ziyodbek")
                .password("{noop}qwerty")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .csrf()
//                .disable()
////                .exceptionHandling()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
//                .authorizeRequests()
//                .antMatchers("/api/**")
//                .permitAll()
//                .antMatchers()
//                .authenticated();

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin();

    }
}
