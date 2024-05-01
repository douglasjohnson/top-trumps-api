package home.dj.springbootopenapimongodb.user;

import home.dj.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity dtoToEntity(User user);

    User entityToDto(UserEntity userEntity);

}
