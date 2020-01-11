package pl.sebastian.security;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


   @Bean
   public UserDetailsService userDetailsService() {


       UserDetails user =  User.withDefaultPasswordEncoder()
               .username("user")
               .password("user")
               .roles("USER")
               .build();


       return new InMemoryUserDetailsManager(user);
   }
   // csrf().disable()
   @Override
   protected void configure(HttpSecurity http) throws Exception {


       http.authorizeRequests()
               .antMatchers("/","/incomplete","/done").hasRole("USER")
               .anyRequest().permitAll()
               .and()
               .formLogin().permitAll()
               .and()
               .logout().permitAll();



   }



}
