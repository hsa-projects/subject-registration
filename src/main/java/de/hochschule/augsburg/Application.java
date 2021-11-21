package de.hochschule.augsburg;

import de.hochschule.augsburg.emailService.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import java.io.IOException;

@SpringBootApplication
public class Application {
  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }


}