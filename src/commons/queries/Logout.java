package commons.queries;

import java.io.Serializable;

public class Logout implements Serializable {
    public String username;

    public Logout(String username) {
        this.username = username;
    }
}
