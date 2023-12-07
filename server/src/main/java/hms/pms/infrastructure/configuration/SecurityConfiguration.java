package hms.pms.infrastructure.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return null;
        //  http
        //         .csrf(csrf -> csrf.disable())
        //         .authorizeHttpRequests(auth -> {
        //             // auth.requestMatchers("/login/**").permitAll();
        //             // auth.requestMatchers("/admin/**").hasRole("ADMIN");
        //             // auth.requestMatchers("/doctor/**").hasRole("DOCTOR");
        //             // auth.requestMatchers("/nurse/**").hasRole("NURSE");
        //             auth.anyRequest().authenticated();
        //         });

        //     return http.build();

        }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public AuthenticationManager authManager(UserDetailsService detailsService){
    //     DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
    //     daoProvider.setUserDetailsService(detailsService);
    //     return new ProviderManager(daoProvider);
    // }

}





