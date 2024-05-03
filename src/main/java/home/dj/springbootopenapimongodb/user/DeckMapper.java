package home.dj.springbootopenapimongodb.user;

import home.dj.model.Deck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeckMapper {

    DeckEntity dtoToEntity(Deck deck);

    Deck entityToDto(DeckEntity deckEntity);

}
