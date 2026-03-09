package Storage;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static final Map<String, String> USER_PASSWORDS = new HashMap<>();
    private static final Map<String, String> USER_ROLES = new HashMap<>();

    static {
        USER_PASSWORDS.put("admin", "admin123");
        USER_ROLES.put("admin", "ADMIN");

        USER_PASSWORDS.put("user", "user123");
        USER_ROLES.put("user", "USER");

        USER_PASSWORDS.put("polina", "1111");
        USER_ROLES.put("polina", "USER");
    }

    public static boolean isValidUser(String username, String password) {
        return USER_PASSWORDS.containsKey(username)
                && USER_PASSWORDS.get(username).equals(password);
    }
    public static String getRole(String username) {
        return USER_ROLES.get(username); }}