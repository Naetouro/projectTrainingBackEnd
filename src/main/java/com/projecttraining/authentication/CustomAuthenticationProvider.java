package com.projecttraining.authentication;

import com.projecttraining.data.objects.UserDO;
import com.projecttraining.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author quentin
 */
@Component
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUserRepository repo;

    /**
     *
     */
    @Override
    public Authentication authenticate(final Authentication authentication) {

        final String userName = authentication.getName();
        final String password = authentication.getCredentials().toString();

        System.out.println(userName);
        System.out.println(password);
        System.out.println(authentication.getPrincipal().toString());
        System.out.println(authentication.getDetails().toString());

        UserDO utilisateurEntity = repo.findByName(userName);

        System.out.println("AUTH");
        if (utilisateurEntity != null) {
            return new UsernamePasswordAuthenticationToken(utilisateurEntity, password, authentication.getAuthorities());
        }


        return null;
    }

    /**
     *
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

