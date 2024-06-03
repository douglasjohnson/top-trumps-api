package home.dj.toptrumps.db;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import home.dj.toptrumps.user.UserEntity;
import home.dj.toptrumps.user.UserStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    @Value("${spring.data.mongodb.database}")
    private String defaultDatabaseName;

    @Bean
    @Lazy
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new DatabaseFactory(connectionString, defaultDatabaseName));
    }

    private static class DatabaseFactory extends SimpleMongoClientDatabaseFactory {

        public DatabaseFactory(String connectionString, String databaseName) {
            super(MongoClients.create(connectionString), databaseName);
        }

        @Override
        protected MongoDatabase doGetMongoDatabase(String dbName) {
            UserEntity user = UserStorage.getUser();
            String databaseName = dbName;
            if (user != null) {
                databaseName = "%s_%s".formatted(dbName, user.getId());
            }
            return super.doGetMongoDatabase(databaseName);
        }
    }
}