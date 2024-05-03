package home.dj.springbootopenapimongodb.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttributeTypeEntity {
    private String name;
    private String units;
}
