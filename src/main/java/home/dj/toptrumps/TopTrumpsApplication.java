package home.dj.toptrumps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = { MongoAutoConfiguration.class,  MongoDataAutoConfiguration.class })
public class TopTrumpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopTrumpsApplication.class, args);
    }

}
