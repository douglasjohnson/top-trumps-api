package home.dj.springbootopenapimongodb.user;

import home.dj.model.Attribute;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeMapper {
    AttributeEntity dtoToEntity(Attribute attribute);
}
