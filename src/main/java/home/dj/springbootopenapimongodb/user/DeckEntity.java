package home.dj.springbootopenapimongodb.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Builder
@Document(value = "decks")
public class DeckEntity {
    @Id
    private String id;
    private String name;
    private String imageUrl;
    private List<CardEntity> cards;
    private List<AttributeTypeEntity> attributes;
}
