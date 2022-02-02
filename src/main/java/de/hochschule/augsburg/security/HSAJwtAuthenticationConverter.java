package de.hochschule.augsburg.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class HSAJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(final Jwt jwt) {

        final String username = jwt.getClaim("preferred_username");

        // Collect all roles from jwt-token
        final List<String> rawRoles = jwt.getClaim("roles");
        final List<String> roles = rawRoles.stream().map(role-> "ROLE_" + role).collect(Collectors.toList());

        //WICHTIG: ROLE_ muss vorhanden sein
        final List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        
        return new JwtAuthenticationToken(jwt, authorities);
    }
}
