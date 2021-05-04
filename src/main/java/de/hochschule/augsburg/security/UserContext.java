package de.hochschule.augsburg.security;

import org.springframework.stereotype.Component;

@Component
public class UserContext {

    public String getLoggedInUser() {
        return "testuser";
    }

}
