package home.dj.toptrumps.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(value = "users")
public class UserEntity {
    @Id
    private String id;
    private String email;
}
