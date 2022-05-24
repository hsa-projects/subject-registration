# Changing between local and hsa realm

This page shows the user, how to change between a localy usable realm and the hsa realm, which needs a vpn connection to the network of the university.

# Getting started

**Note:** The realm "hsa-realm.json"/"hsa" only works with an activated vpn connection to the network of the University of Applied Sciences Augsburg!

### 1. Adding the local-realm.json to the realms

At first, you have to make sure, that the local realm has been added to keycloak. The file for this process has already been configuered. The file is located at the path `subject-registration/docker/keycloak/realms/local-realm.json`.

After setting up the whole project and staring all needed services, log into the keycloak-panel as an admin and click on "add realm". After that, you need to pick the file "local-realm.json", pick a name for the realm (this example uses "local" as a name) and enable it. After creating the realm, it should be accessible to the web app.

### 2. Adding a test user to the realm

After adding the local realm to your keycloak server, you will need to setup a user, with which you will be able to log into your local realm. This can easily be done by clicking on 'Users' inside your keycloak panel and then clicking on 'Add user'. After navigating to that page, you can choose your user name, password and other things aswell. Do not forget to save the user! Now the user is created on the local realm.

### 3. Changing the used realm in the frontend

To use the local realm in the actual web app, you need to change the "realm" attribute in the "file keycloak.json" located at `subject-registration/frontend/keycloak/public/keycloak.json`. The default value should be 'hsa'. Now you have to change the value of the attribute to the name, which you have selected for the local realm ('local' in this example).

Now you can start all services again and the app will use a local realm, which does not need a vpn connection and you will be able to log in to your user, which was created earlier in this documentation.
