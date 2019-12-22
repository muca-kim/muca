package com.project.config;

import com.project.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {

        web.ignoring().antMatchers("/css/**", "/script/**", "/image/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 페이지 권한 설정
                // .antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/myinfo").hasRole("MEMBER")
                .antMatchers("/**").permitAll().and()
                // 로그인 설정
                .formLogin().loginPage("/login").usernameParameter("userId").passwordParameter("userPassword")
                .defaultSuccessUrl("/mainPage").permitAll().and()
                // 로그아웃
                // .logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                // .logoutSuccessUrl("/user/logout/result").invalidateHttpSession(true).and()
                // 403 예외처리 핸들링
                .exceptionHandling().accessDeniedPage("/");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    // }

    // ログインを要請したユーザーが登録されているかいなかを確認するクラス
    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        UserService userService;

        /**
         * 認証済みのオブジェクトの生成
         * 
         * @param auth 認証を行うインスタンス
         * @return void
         */
        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            // 認証するユーザーを設定する
            auth.userDetailsService(userService)
                    // 入力値をmd5でハッシュ化した値でパスワード認証を行う
                    .passwordEncoder(new BCryptPasswordEncoder());

        }
    }

}