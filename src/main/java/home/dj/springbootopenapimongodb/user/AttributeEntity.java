package home.dj.springbootopenapimongodb.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttributeEntity {
    private String type;
    private String value;
}
