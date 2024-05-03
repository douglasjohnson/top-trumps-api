package home.dj.springbootopenapimongodb.user;

import home.dj.model.Deck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeckService {

    private final DeckRepository deckRepository;
    private final DeckMapper deckMapper;

    public List<Deck> findAll() {
        return deckRepository.findAll().stream().map(deckMapper::entityToDto).toList();
    }

    public Deck find(String id) {
        Optional<DeckEntity> deckEntity = deckRepository.findById(id);
        return deckEntity.map(deckMapper::entityToDto).orElse(null);
    }

    public Deck save(Deck deck) {
        return deckMapper.entityToDto(deckRepository.save(deckMapper.dtoToEntity(deck)));
    }

    public void delete(String id) {
        deckRepository.delete(DeckEntity.builder().id(id).build());
    }
}
