package commons.queries;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    public String username,password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
