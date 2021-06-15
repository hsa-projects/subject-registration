package de.hochschule.augsburg.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class UserContext {

    public String getLoggedInUser() {
        final Jwt auth = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getClaim("preferred_username");
    }

}
