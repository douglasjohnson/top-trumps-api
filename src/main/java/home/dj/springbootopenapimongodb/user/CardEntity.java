package home.dj.springbootopenapimongodb.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CardEntity {
    private String name;
    private String description;
    private String imageUrl;
    private List<AttributeEntity> attributes;
}
