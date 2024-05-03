package home.dj.springbootopenapimongodb.user;

import home.dj.model.Deck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeckController.class)
@ExtendWith(MockitoExtension.class)
class DeckControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DeckService deckService;

    @Test
    void findAll_shouldReturnAllUsers() throws Exception {
        when(deckService.findAll()).thenReturn(List.of(new Deck().id("1").name("Deck 1")));

        String expected = """
                [{
                  id: '1',
                  name: 'Deck 1'
                }]
                """;
        this.mockMvc.perform(get("/decks"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(expected));
    }
}