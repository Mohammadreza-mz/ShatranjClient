package commons.queries;

import java.io.Serializable;

public class DeleteAccount implements Serializable {
    public String username;

    public DeleteAccount(String username) {
        this.username = username;
    }
}
