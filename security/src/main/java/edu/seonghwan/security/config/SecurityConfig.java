package edu.seonghwan.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정하겠다는 의미
                .antMatchers("/api/hello").permitAll() // /api/hello -> 요청은 접근 허용
                .anyRequest().authenticated(); // 나머지 요청들은 모두 인증
    }

}
