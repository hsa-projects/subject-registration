import { createContext } from "react";

import Keycloak from "keycloak-js";

/**
 * Saves the credentials of the currently logged in user.
 * @type {React.Context<{user: {}}>}
 */
const userContext = createContext({
    user: {},
    setUser: (user: Keycloak.KeycloakInstance) => { }
});

export default userContext;
