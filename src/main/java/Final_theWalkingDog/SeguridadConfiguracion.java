package Final_theWalkingDog;

import Final_theWalkingDog.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SeguridadConfiguracion extends WebSecurityConfigurerAdapter {

    @Autowired
//    @Qualifier("usuarioServicio")
    public UsuarioServicios usuarioServicio;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(usuarioServicio)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.headers().frameOptions().sameOrigin().and()
                .authorizeRequests()
                            .antMatchers("/static/*","/templates/*","/imagenes/*")
                            .permitAll()
                .and().formLogin()
                             .loginPage("/iniciosesionusuario")
                                        .loginProcessingUrl("/logincheck")
                                        .usernameParameter("username")
                                        .passwordParameter("password")
                                        .defaultSuccessUrl("/perfilusuario")
                                        .permitAll()
                             .and().logout()
                             .logoutUrl("/logout")
                            .logoutSuccessUrl("/")
                            .permitAll();

    }

}
