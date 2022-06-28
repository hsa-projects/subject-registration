# Changing between local and hsa realm

This page shows the user, how to change between a localy usable realm and the hsa realm, which needs a vpn connection to the network of the university.

# Getting started

**Note:** The realm "hsa-realm.json"/"hsa" only works with an activated vpn connection to the network of the University of Applied Sciences Augsburg!

### 1. Changing the file in docker-compose-file

You have to make sure, that the local realm has been added to the docker-compose-file located at `subject-registration/docker/docker-compose.yml`. Here you can change the realm at `KEYCLOAK_IMPORT` to the desired realm. Currently there are two available options: The local-realm.json and the hsa-realm.json. The first one is used for local development, in which you won´t need a VPN-connection to the network of the university. The second one will be used at production level and will need a active VPN-connection to the universities network in order to function properly.
After starting keycloak via the docker-compose command, the realm you choose should be shown in the realm-list.

### (Optional) Adding a test user to the realm

After adding the local realm to your keycloak server, you can setup a user, with which you will be able to log into your local realm. This can easily be done by clicking on 'Users' inside your keycloak panel and then clicking on 'Add user'. After navigating to that page, you can choose your user name, password and other things aswell. Do not forget to save the user! Now the user is created on the local realm. This is only optional though, since there is a standard user, which always gets created with the name: test and the password: test

### 2. Changing the used realm in the frontend

To use the local realm in the actual web app, you need to change the "realm" attribute in the file "keycloak.json" located at `subject-registration/frontend/keycloak/public/keycloak.json`. The default value should be 'hsa'. Now you have to change the value of the attribute to the name, which has been selected as the id in the realm-file for the choosen real ('local' in this example).

Now you can start all services again and the app will use a local realm, which does not need a vpn connection and you will be able to log in to your user, if you created a new one. You can also log in with the admin-account created for the keycloak-realm, which is why adding a new user is optional, because the admin user already exists.