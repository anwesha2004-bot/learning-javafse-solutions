public class UserRepository {

    private java.util.Map<Long, User> database = new java.util.HashMap<>();

    public void save(User user) {
        database.put(user.getId(), user);
    }

    public User findById(Long id) {
        return database.get(id); // Not Optional
    }
}
