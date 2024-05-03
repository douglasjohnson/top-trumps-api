package home.dj.springbootopenapimongodb.user;

import home.dj.api.DecksApi;
import home.dj.model.Deck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeckController implements DecksApi {

    private final DeckService deckService;

    @Override
    public ResponseEntity<List<Deck>> findAll() {
        return ResponseEntity.ok(deckService.findAll());
    }

    @Override
    public ResponseEntity<Deck> find(String id) {
        return ResponseEntity.ok(deckService.find(id));
    }

    @Override
    public ResponseEntity<Deck> create(Deck deck) {
        Deck savedDeck = deckService.save(deck);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedDeck.getId()).toUri()).body(savedDeck);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        deckService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Deck> update(String id, Deck deck) {
        return ResponseEntity.ok(deckService.save(deck));
    }
}
