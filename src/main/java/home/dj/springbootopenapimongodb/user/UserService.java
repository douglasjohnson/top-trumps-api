package home.dj.springbootopenapimongodb.user;

import home.dj.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> findAll() {
        return userRepository.findAll().stream().map(userMapper::entityToDto).toList();
    }

    public User find(String id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(userMapper::entityToDto).orElse(null);
    }

    public User save(User user) {
        return userMapper.entityToDto(userRepository.save(userMapper.dtoToEntity(user)));
    }

    public void delete(String id) {
        userRepository.delete(UserEntity.builder().id(id).build());
    }
}
