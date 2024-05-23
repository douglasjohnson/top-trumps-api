package home.dj.toptrumps.deck;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttributeEntity {
    private String type;
    private Double value;
}
