
# HSA Subject Registration Project
Welcome to the HSA subject registration project!

This project is about a development of a web application where a student can register for elecitve courses.

The main goals are a user-friendly design and simple operations for the subject registration process.


## Built With
* Backend: [Java](https://www.java.com/de/) and [Spring Boot](https://spring.io)
* Frontend: [Typescript](https://www.typescriptlang.org) and [React](https://reactjs.org)
* Process Modelling: [Camunda](https://camunda.com)

## Getting Started
Note: Make sure that you're connected to the HSA VPN (necessary for authentication to work)! Please refer to this [page](https://www.hs-augsburg.de/en/IT-Services-Center-2/Network.html) for more information.
### Prerequisties
Before you can start the project, you have to install the following requirements:
* [Java](https://openjdk.java.net/projects/jdk/11/) ```sudo apt install openjdk-11-jdk```

* [NPM](https://www.npmjs.com) ```sudo apt install npm``` 

* [Docker](https://www.docker.com) ```sudo apt install docker.io```

### Start the Project
#### 0. Install dependencies

At first, the dependencies of this project need to be installed. Run``` npm install ```or```yarn```  inside the project root folder in order to do this.

#### 1. Keycloak server

Init the keycloak server with ``` sudo docker-compose up```(at path ``` subject-registration/docker```, backend repo)

* Note: if the keycloak server is already initialized, you only have to start the container via ```sudo docker-compose start```
* Use ``` sudo docker-compose stop```  to stop the container
#### 2. Backend

Start the backend: either in IntelliJ by clicking on the Start Application button or in a terminal with command ```mvn spring-boot:run```  (run inside project root folder)

#### 3. Generate API client

In order to generate the API client, run the script ``` npm run apiGeneration``` inside the project root folder. Make sure that backend is running at the time you do this.

* Note: generally, you only need to generate the client once. You should, however, re-run the script if some changes are made in backend.
#### 4. Start frontend

Start the frontend with ``` npm run start```  (run inside project root folder)

Now a new page on your browser should show up with the address http://localhost:3000/

## License
Distributed under the MIT License. See [MIT License](https://opensource.org/licenses/MIT) for more information.