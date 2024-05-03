package home.dj.springbootopenapimongodb.user;

import home.dj.model.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeckServiceTest {

    @Mock
    private DeckRepository deckRepository;
    private DeckService deckService;

    @BeforeEach
    void setUp() {
        deckService = new DeckService(deckRepository, Mappers.getMapper(DeckMapper.class));
    }

    @Test
    void findAll_shouldReturnAllDecks() {
        when(deckRepository.findAll()).thenReturn(asList(
                deckEntity("1", "Deck 1"),
                deckEntity("2", "Deck 2")
        ));

        List<Deck> users = deckService.findAll();

        assertThat(users, contains(
                new Deck().id("1").name("Deck 1"),
                new Deck().id("2").name("Deck 2")
        ));
    }

    @Test
    void find_shouldReturnDeck() {
        when(deckRepository.findById("1")).thenReturn(Optional.of(deckEntity("1", "Deck 1")));

        assertThat(deckService.find("1"), is(new Deck().id("1").name("Deck 1")));
    }

    @Test
    void find_shouldReturnNullWhenNotFound() {
        when(deckRepository.findById("1")).thenReturn(Optional.empty());

        assertThat(deckService.find("1"), is(nullValue()));
    }

    private static DeckEntity deckEntity(String id, String name) {
        return DeckEntity.builder().id(id).name(name).build();
    }
}