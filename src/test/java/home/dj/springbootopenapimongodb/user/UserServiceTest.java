package home.dj.springbootopenapimongodb.user;

import home.dj.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, Mappers.getMapper(UserMapper.class));
    }

    @Test
    void findAll_shouldReturnAllUsers() {
        when(userRepository.findAll()).thenReturn(asList(
                userEntity("1", "User 1"),
                userEntity("2", "User 2")
        ));

        List<User> users = userService.findAll();

        assertThat(users, contains(
                new User().id("1").name("User 1"),
                new User().id("2").name("User 2")
        ));
    }

    @Test
    void find_shouldReturnUser() {
        when(userRepository.findById("1")).thenReturn(Optional.of(userEntity("1", "User 1")));

        assertThat(userService.find("1"), is(new User().id("1").name("User 1")));
    }

    @Test
    void find_shouldReturnNullWhenNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        assertThat(userService.find("1"), is(nullValue()));
    }

    private static UserEntity userEntity(String id, String name) {
        return UserEntity.builder().id(id).name(name).build();
    }
}