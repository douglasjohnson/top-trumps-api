package home.dj.springbootopenapimongodb.user;

import home.dj.model.AttributeType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeTypeMapper {
    AttributeTypeEntity dtoToEntity(AttributeType attributeType);
}
