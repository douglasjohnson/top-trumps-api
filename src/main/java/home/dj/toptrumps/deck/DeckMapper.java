package home.dj.toptrumps.deck;

import home.dj.model.Deck;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

@Mapper(componentModel = "spring", nullValueIterableMappingStrategy = RETURN_DEFAULT)
public interface DeckMapper {

    DeckEntity dtoToEntity(Deck deck);

    Deck entityToDto(DeckEntity deckEntity);

}
