package home.dj.toptrumps.deck;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends MongoRepository<DeckEntity, String> {
}
