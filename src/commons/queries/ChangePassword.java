package commons.queries;

import java.io.Serializable;

public class ChangePassword implements Serializable {
    public String username,password;

    public ChangePassword(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
