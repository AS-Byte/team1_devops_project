package tn.esp.team1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Team1Application {

    public static void main(String[] args) {
        SpringApplication.run(Team1Application.class, args);
    }

}
