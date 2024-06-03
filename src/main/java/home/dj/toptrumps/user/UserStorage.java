package home.dj.toptrumps.user;

public class UserStorage {

    private static final ThreadLocal<UserEntity> storage = new ThreadLocal<>();

    public static UserEntity getUser() {
        return storage.get();
    }

    public static void setUser(UserEntity user) {
        storage.set(user);
    }

    public static void clear() {
        storage.remove();
    }

}
