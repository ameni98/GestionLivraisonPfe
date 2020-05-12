package net.javaguides.springboot.springsecurity.config;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Properties;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import net.javaguides.springboot.springsecurity.model.Admin;
import net.javaguides.springboot.springsecurity.model.MySimpleUrlAuthenticationSuccessHandler;
import net.javaguides.springboot.springsecurity.model.PasswordResetToken;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.PasswordTokenRepository;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.service.UserServiceImpl;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceImpl userServiceImpl;

    
   
   
  /*  @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }
    */
   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    //Garantit que toute demande à notre application nécessite que l'utilisateur soit authentifié
    //Permet aux utilisateurs de sauthentifier avec une connexion basée sur un formulaire
    //Permet aux utilisateurs de s'authentifier avec l'authentification HTTP Basic
   
               
             //   ignoring().antMatchers("/the_js_path/**");
        http
        .authorizeRequests().antMatchers("/admin/** ** ").hasAnyRole("ROLE_ADMIN").and().authorizeRequests().
       
        antMatchers(
                    //indiquent que cela HttpSecurity ne sera applicable qu'aux URL commençant par/registration
                    //Cela permet à quiconque d'accéder à une URL commençant par / resources / .
                    //Puisque c'est là que nos css, javascript et images sont stockés, toutes nos ressources statiques sont visibles par n'importe qui.
        		 "/Accueil**","/registration**","/com**",
                 "/js/**",
                 "/css/**",
                 "/resources/**",
                 "/fonts/**",
                 "/scss/**",
                 "/images/**",
                 "/webjars/**").permitAll()
                    //1 every request requires the user to be authenticated(chaque demande nécessite que l'utilisateur soit auhentifié)
                    .anyRequest().authenticated()//1
                .and()
                //2 l'authentification basée sur le formulaire est prise en charge
                    .formLogin()//2
                        .loginPage("/login").loginProcessingUrl("/login").successHandler(myAuthenticationSuccessHandler())
                                    
/*La ligne loginPage("/login")demande à Spring Security

lorsque l'authentification est requise, redirigez le navigateur vers / login

nous sommes en charge de rendre la page de connexion lorsque / login est demandé

lorsque la tentative d'authentification échoue, redirigez le navigateur vers / login? error (puisque nous n'avons pas spécifié le contraire)

nous sommes chargés de rendre une page d'échec lorsque / login? erreur est demandée

lorsque nous nous déconnectons avec succès, rediriger le navigateur vers / login? logout (puisque nous n'avons pas spécifié le contraire)

nous sommes en charge de rendre une page de confirmation de déconnexion lorsque / login? logout est demandé*/
                            .permitAll()
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        //Comme vous pouvez vous y attendre, logout().permitAll()
                        //permet à tout utilisateur de demander la déconnexion et d'afficher l'URL de réussite de la déconnexion.
                .permitAll();
               // .and().csrf().disable() .authorizeRequests() .anyRequest().permitAll(); 
    }

    //pour faire le hashage de code
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
   
        return new BCryptPasswordEncoder();
    }
 //  DaoAuthentificationProvider fournisseurs dauthentification
    //le DaoAuthenticationProvider exploite un UserDetailsService afin de rechercher le nom d'utilisateur, le mot de passe et
    //GrantedAuthority [] s. Contrairement à la plupart des autres fournisseurs d'authentification qui exploitent UserDetailsService,
    //ce fournisseur d'authentification nécessite en fait que le mot de passe soit présenté, et le fournisseur
    //évaluera réellement la validité ou non du mot de passe présenté dans un objet de demande d'authentification.
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
    //Vous devez absolument définir un et un seul AuthenticationManagerBuilder dans votre application.
    //Cette classe permet de définir quel sera le mode d’authentification des utilisateurs
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
   /* private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }*/
    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }

   
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
  
   
    
    }



