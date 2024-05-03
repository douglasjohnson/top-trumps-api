package home.dj.springbootopenapimongodb.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends MongoRepository<DeckEntity, String> {
}
